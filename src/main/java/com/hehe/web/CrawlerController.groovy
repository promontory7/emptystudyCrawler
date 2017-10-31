package com.hehe.web

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import com.google.common.collect.Sets
import com.hehe.model.BookWithBLOBs
import com.hehe.pageProcessor.JdPageProcessor
import com.hehe.pageProcessor.base.BasePageProcessor
import com.hehe.service.impl.BookService
import com.hehe.util.HttpclientUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import us.codecraft.webmagic.Spider
import us.codecraft.webmagic.downloader.HttpClientDownloader
import us.codecraft.webmagic.proxy.Proxy
import us.codecraft.webmagic.proxy.SimpleProxyProvider

/**
 * Created by hehe on 2017/6/23.
 */
@Controller
@RequestMapping('/crawler')
class CrawlerController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookService bookService

    @RequestMapping(value = '/start', method = RequestMethod.GET)
    @ResponseBody
    def start() {
        JdPageProcessor.bookService = bookService

        LOG.info('获取代理中')
//        String proxyUrl = 'http://api.xicidaili.com/free2016.txt'
        //大象代理
//        String proxyUrl ='http://tvp.daxiangdaili.com/ip/?tid=559048042514205&num=50&delay=3&category=2&protocol=https&foreign=none'
//        String responseContent = HttpclientUtil.get(proxyUrl)
//        BufferedReader bufferedReader = new BufferedReader(new StringReader(responseContent))
//        String str = ''
//        ArrayList<Proxy> proxyList =new ArrayList<>()
//        while ((str = bufferedReader.readLine()) != null) {
//            println(str)
//            String[] strings =str.split(':')
//            proxyList.add(new Proxy(strings[0],Integer.parseInt(strings[1])))
//        }
//        Proxy[] proxies =proxyList.toArray()
//
//        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
//        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(proxies));

        LOG.info('开始爬虫...')

        //获取数据库中已经存在怕去过的Url
        println "获取数据库中已经存在的Url"
        BasePageProcessor.existUrls = bookService.getAllUrls();
        println "获取数据库中已经存在的Url成功！一共有 " + BasePageProcessor.existUrls.size()

        Spider.create(new JdPageProcessor())
                .thread(4)
//                .setDownloader(httpClientDownloader)
//                .addUrl('https://item.jd.com/10595593.html')
                .addUrl(BasePageProcessor.defaultUrl)
//                .setDownloader(new SeleniumDownloader("/Users/hehe/program/chromedriver"))
                .runAsync()

        return "start..."

    }

    @RequestMapping(value = '/price', method = RequestMethod.GET)
    @ResponseBody
    def setprice(@RequestParam(value = 'cyclerTime', defaultValue = '3') int cyclerTime) {

        //https://p.3.cn/prices/mgets?skuIds=J_11722862,J_12074267,

        //找出所有价格为空的 isbn
        List<String> withoutPriceList = bookService.getItemIDwithoutPrice()
        if (!withoutPriceList || withoutPriceList.size() < 1) {
            return 'get all the price successful'
        }

        StringBuffer stringBuffer

        //一次读取的条数
        int oneTime = 100
        //请求次数
        int manyTime = withoutPriceList.size() / oneTime + 1
        for (int m = 0; m < manyTime; m++) {

            //每一次请求
            stringBuffer = new StringBuffer('https://p.3.cn/prices/mgets?skuIds=')
            for (int i = 0; i < oneTime && i < withoutPriceList.size(); i++) {
                stringBuffer.append('J_').append(withoutPriceList.get(m * oneTime + i)).append(',')
            }

            try {
                String strHttp = HttpclientUtil.get(stringBuffer.toString().trim())
                JSONArray priceArray = (JSONArray) (JSON.parse(strHttp))
                if (priceArray) {
                    for (int i = 0; i < priceArray.size(); i++) {
                        String isbn = priceArray.getJSONObject(i).getString('id').substring(2).trim()
                        String price = priceArray.getJSONObject(i).getString('p').trim()

                        try {
                            boolean issuccessful = bookService.updatePriceByItemID(new BookWithBLOBs(itemId: isbn, price: Double.parseDouble(price)))
                            if (issuccessful) {
                                LOG.info('设置价格成功 ： ' + 'itemId=' + isbn + "   price=" + price)
                            } else {
                                LOG.error('设置价格失败 ： ' + 'itemId=' + isbn + "   price=" + price)
                            }
                        } catch (Exception e) {
                            e.printStackTrace()
                            LOG.error('插入价格出错 ')
                        }

                    }

                }
            } catch (Exception e) {
                e.printStackTrace()
                LOG.error('获得价格失败 url：' + stringBuffer)
            } finally {
//                Thread.sleep(100)
            }

        }
        if (cyclerTime < 1) {
            return 'cycler out'
        }
        setprice(cyclerTime - 1)


    }

    @RequestMapping(value = '/urls', method = RequestMethod.GET)
    @ResponseBody
    def getAllUrl() {
        List<String> urls = bookService.getAllUrls();
        return urls
    }
}
