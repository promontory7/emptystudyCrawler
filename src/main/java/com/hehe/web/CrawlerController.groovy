package com.hehe.web

import com.hehe.pageProcessor.JdPageProcessor
import com.hehe.pageProcessor.base.BasePageProcessor
import com.hehe.service.IBookService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import us.codecraft.webmagic.Spider

/**
 * Created by hehe on 2017/6/23.
 */
@Controller
@RequestMapping('/crawler')
class CrawlerController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IBookService bookService

    @RequestMapping(value = '/start', method = RequestMethod.GET)
    @ResponseBody
    def start() {
        JdPageProcessor.bookService = bookService
        LOG.info('开始爬虫...')


        Spider.create(new JdPageProcessor())
                .thread(1)
//                .addUrl('https://item.jd.com/10595593.html')
                .addUrl(BasePageProcessor.defaultUrl)
//                .setDownloader(new SeleniumDownloader("/Users/hehe/program/chromedriver"))
                .runAsync()
//        return "爬取结束"

    }
}
