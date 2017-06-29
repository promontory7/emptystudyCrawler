package com.hehe.dao;

import com.hehe.model.Book;
import com.hehe.model.BookWithBLOBs;

import java.util.List;

public interface BookMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbg.generated
     */
    int insert(BookWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbg.generated
     */
    int insertSelective(BookWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbg.generated
     */
    BookWithBLOBs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(BookWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(BookWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Book record);

    int updateByISBN(BookWithBLOBs record);

    List<String> getItemIDwithoutPrice();

    int updatePriceByItemID(BookWithBLOBs record);

}