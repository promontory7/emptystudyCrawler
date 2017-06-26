package com.hehe.service.impl

import com.hehe.dao.BookMapper
import com.hehe.model.Book
import com.hehe.service.IBookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.sql.Timestamp

/**
 * Created by hehe on 2017/6/24.
 */
@Service
class BookService implements IBookService {

    @Autowired
    private BookMapper bookMapper

    @Override
    boolean insertBook(Book book) {
        book.createTime = new Timestamp(System.currentTimeMillis())
        return bookMapper.insert(book)
    }
}
