package com.hehe.service.impl

import com.hehe.dao.BookMapper
import com.hehe.model.BookWithBLOBs
import com.hehe.service.IBookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.sql.Timestamp

/**
 * Created by hehe on 2017/6/24.
 */
@Service
class BookService implements IBookService  {

    @Autowired
    private BookMapper bookMapper

    @Override
    boolean insertBook(BookWithBLOBs book) {
        book.createTime = new Timestamp(System.currentTimeMillis())
        return bookMapper.insert(book)
    }

    boolean updateBookByISBN(BookWithBLOBs book) {
        book.modifyTime = new Timestamp(System.currentTimeMillis())
        return bookMapper.updateByISBN(book)
    }

    List<String> getItemIDwithoutPrice() {
        return bookMapper.getItemIDwithoutPrice()
    }

    boolean updatePriceByItemID(BookWithBLOBs book) {
        book.modifyTime =  new Timestamp(System.currentTimeMillis())
        return bookMapper.updatePriceByItemID(book)
    }

    List<String> getAllUrls(){
        return  bookMapper.selectAllUrl();
    }
}
