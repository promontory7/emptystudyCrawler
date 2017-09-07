package com.hehe.service

import com.hehe.model.BookWithBLOBs

/**
 * Created by hehe on 2017/6/24.
 */
interface IBookService {

    boolean insertBook(BookWithBLOBs book);
    boolean updateBookByISBN(BookWithBLOBs book)
    List<String> getItemIDwithoutPrice()
    boolean updatePriceByItemID(BookWithBLOBs book)
    List<String> getAllUrls()

}