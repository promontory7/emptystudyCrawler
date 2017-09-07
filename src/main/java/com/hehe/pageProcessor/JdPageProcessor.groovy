package com.hehe.pageProcessorimport com.alibaba.fastjson.JSONimport com.alibaba.fastjson.JSONArrayimport com.alibaba.fastjson.JSONObjectimport com.hehe.model.BookWithBLOBsimport com.hehe.pageProcessor.base.BasePageProcessorimport com.hehe.service.IBookServiceimport com.hehe.util.HttpclientUtilimport org.jsoup.Jsoupimport org.jsoup.nodes.Elementimport org.jsoup.select.Elementsimport org.slf4j.Loggerimport org.slf4j.LoggerFactoryimport us.codecraft.webmagic.Pageimport java.util.regex.Matcherimport java.util.regex.Pattern/** * Created by hehe on 2017/6/23. * 京东网 */class JdPageProcessor extends BasePageProcessor {    private final Logger LOG = LoggerFactory.getLogger(this.getClass());    static IBookService bookService    //链接中的商品匹配符    Pattern pattern = Pattern.compile("\\d{2,38}");    @Override    List<String> setBaseUrlAndSum() {        List<String> lists = new ArrayList<>()        Elements ul = document.getElementsByClass('menu-drop-list')        if (ul) {            ul.select('a').each {                lists.add('https://list.jd.com' + it.attr('href').toString().trim() + '&page=1&delivery=1&stock=0&sort=sort_totalsales15_desc&trans=1')            }        } else {            LOG.error('找不到各分类列表地址')        }        LOG.info('各分类列表地址' + lists.toArray().toString())        return lists    }    @Override    def setTypeOfUrl() {        ["https://list\\.jd\\.com/list\\.html\\?cat\\=1713*",         "https://item\\.jd\\.com/\\d+\\.html*"]    }    @Override    def listPrecess(Page page) {        LOG.warn('列表处理')        List<String> lists = page.getHtml().xpath('//ul[@class=\'gl-warp clearfix\']').links().regex("//item\\.jd\\.com/\\d+\\.html*").all()        LOG.warn('本列表页面获得' + lists.size() + '个商品详情连接:  ' + lists.toArray().toString())        for (String url : lists) {            //判断此链接是否已经爬过            if (existUrls.contains("https:" + url.trim())) {                LOG.warn('此详情链接已经存在，不需要爬取：' + url)            } else {                page.addTargetRequest(url)                LOG.warn('增加详情爬取链接：' + url)            }        }        //下一页        try {            Elements nexts = Jsoup.parse(page.getHtml().toString()).getElementById("J_bottomPage").getElementsByClass('pn-next')            if (nexts) {                String nextUrl = 'https://list.jd.com' + nexts.get(0).attr('href')                page.addTargetRequest(nextUrl)                LOG.warn('增加下一页链接：' + nextUrl)            } else {                LOG.warn('已经是最后一页' + page.toString())                LOG.warn('已经是最后一页' + page.getUrl().toString().trim())            }        }catch (Exception e){            LOG.warn('已经是最后一页,找不到J_bottomPage' + page.toString())            LOG.warn('已经是最后一页' + page.getUrl().toString().trim())        }    }    @Override    def detailProcess(Page page) {        LOG.warn('详情处理')        book = new BookWithBLOBs()        //图片链接        book.image = 'https:' + document.getElementById('spec-n1').select('img').get(0).attr('src').toString().trim()        //书名        book.name = document.getElementById('name').select('h1').get(0).text()        //促销语        book.promontion = document.getElementById('p-ad').text()        //价格//        String price = document.getElementById('jd-price').text()        //作者        book.author = document.getElementById('p-author').text()        //ISBN        String isbn = ''        Element parameter2 = document.getElementById('parameter2')        if (parameter2) {            Elements elements = parameter2.children()            if (elements) {                book.publisher = elements.get(0).attr('title')                isbn = elements.get(1).attr('title')            }        }        book.isbn = isbn        String itemID = ''        Matcher matcher = pattern.matcher(currentUrl);        if (matcher.find()) {            itemID = matcher.group(0)            LOG.info('链接中的ID:' + itemID)        } else {            LOG.error('找不到链接中的商品 ID')//            itemID = isbn        }        if (!itemID) {            LOG.error('链接中的ID不存在' + itemID)            return        }        book.itemId = itemID        //价格//        try {//            JSONArray priceArray = (JSONArray) (JSON.parse(HttpclientUtil.get('https://p.3.cn/prices/get?skuid=J_' + itemID)))//            if (priceArray) {//                book.price = Double.parseDouble(priceArray.getJSONObject(0).getString('p'))//            }//        } catch (Exception e) {//            e.printStackTrace()//            LOG.error('商品价格不存在不存在' + itemID)//        }        //https://dx.3.cn/desc/12074267?callback=showdesc        String responseContent = HttpclientUtil.get('https://dx.3.cn/desc/' + itemID + '?callback=showdesc')        JSONObject responseJson = (JSONObject) JSON.parse(responseContent.substring(responseContent.indexOf('{'), responseContent.length() - 1))        String contentString = '<div id="J-detail-content">' + responseJson.getString('content') + '</div>'        Elements details = Jsoup.parse(contentString).getElementById('J-detail-content').children()        details.each {            String type = it.attr('text').trim()            if (type) {                Elements elements = it.getElementsByClass('book-detail-content')                if (elements) {                    String content = elements.get(0).html()                    switch (type) {                        case '内容简介':                            book.brief = content                            break                        case '作者简介':                            book.authorBrief = content                            break                        case '目录':                            book.catalog = content                            break                        case '精彩书摘':                            book.digest = content                            break                        default:                            break                    }                }            }        }        book.url = currentUrl        book.validate = 1        try {            boolean successful = bookService.insertBook(book)            if (successful) {                LOG.info('保存商品信息成功:   ' + book.toString())            } else {                LOG.error('保存商品信息失败:   ' + book.toString())            }        } catch (Exception e) {            e.printStackTrace()            LOG.info('商品已存在，。。。')            LOG.info(book.toString())        }        return null    }    @Override    def parseContent(String content) {        return null    }}