package com.hehe.pageProcessor.base

import com.hehe.model.Book
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import us.codecraft.webmagic.Page
import us.codecraft.webmagic.Site
import us.codecraft.webmagic.processor.PageProcessor

/**
 * 处理基础类
 */
abstract class BasePageProcessor implements PageProcessor {
    Document document
    Book book

    static String defaultUrl = 'https://list.jd.com/list.html?cat=1713,3258'
    String listUrl      //列表页
    String detailUrl    //详情页

    String pageNumSymbol = 'pagaNumber' //页码符号
    String baseUrl;//列表网址（含页码符号）
    int pageStart; //抓取的列表初始页码
    int pageEnd    //抓取的列表尾页码

    @Override
    void process(Page page) {

        document = Jsoup.parse(page.getHtml().toString());
        //初始URL，添加所有列表url
        if (page.getUrl().toString().trim() == defaultUrl) {
            (listUrl, detailUrl) = setTypeOfUrl()

//            setBaseUrlAndSum().each {
//                (baseUrl, pageStart, pageEnd) = it
//                if (baseUrl && pageStart && pageEnd) {
//                    pageStart.upto(pageEnd) {
//                        page.addTargetRequest(baseUrl.replace(pageNumSymbol, it + ""))
//                    }
//                }
//            }
            List<String> lists = setBaseUrlAndSum()
            page.addTargetRequests(lists)

        } else if (page.getUrl().regex(listUrl).match()) {
            //列表页处理
            listPrecess(page)
        } else if (page.getUrl().regex(detailUrl).match()) {
            //详情页处理
            detailProcess(page)
        } else {
            println "无法处理网址类型  url $page.url"
        }
    }

    @Override
    Site getSite() {
        Site.me().setDomain("jd.com")
                .setRetryTimes(3)
                .setTimeOut(8000)
                .setSleepTime(0)

    }

    /**
     * 获得要抓取链接的列表
     * @return
     * baseUrl   列表网址（含页码符号）
     * pageStart 抓取的列表初始页码
     * pageEnd   抓取的列表尾页码
     */
    abstract List<String> setBaseUrlAndSum()

    /**
     * 设置 列表URL 和 详情URL 的模板
     */
    abstract def setTypeOfUrl()

    /**
     * 列表页处理
     */
    abstract def listPrecess(Page page)

    /**
     * 详情页处理
     */
    abstract def detailProcess(Page page)

    /**
     * 解析提取字段信息
     * @param content 详情页面内容（有空行符）
     * @return
     */
    abstract def parseContent(String content)

}
