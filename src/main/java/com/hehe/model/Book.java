package com.hehe.model;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.ISBN
     *
     * @mbg.generated
     */
    private String isbn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.image
     *
     * @mbg.generated
     */
    private String image;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.promontion
     *
     * @mbg.generated
     */
    private String promontion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.author
     *
     * @mbg.generated
     */
    private String author;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.publisher
     *
     * @mbg.generated
     */
    private String publisher;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.price
     *
     * @mbg.generated
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.url
     *
     * @mbg.generated
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.modify_time
     *
     * @mbg.generated
     */
    private Date modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.validate
     *
     * @mbg.generated
     */
    private Integer validate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.item_id
     *
     * @mbg.generated
     */
    private String itemId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.id
     *
     * @return the value of book.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.id
     *
     * @param id the value for book.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.ISBN
     *
     * @return the value of book.ISBN
     *
     * @mbg.generated
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.ISBN
     *
     * @param isbn the value for book.ISBN
     *
     * @mbg.generated
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.name
     *
     * @return the value of book.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.name
     *
     * @param name the value for book.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.image
     *
     * @return the value of book.image
     *
     * @mbg.generated
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.image
     *
     * @param image the value for book.image
     *
     * @mbg.generated
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.promontion
     *
     * @return the value of book.promontion
     *
     * @mbg.generated
     */
    public String getPromontion() {
        return promontion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.promontion
     *
     * @param promontion the value for book.promontion
     *
     * @mbg.generated
     */
    public void setPromontion(String promontion) {
        this.promontion = promontion == null ? null : promontion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.author
     *
     * @return the value of book.author
     *
     * @mbg.generated
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.author
     *
     * @param author the value for book.author
     *
     * @mbg.generated
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.publisher
     *
     * @return the value of book.publisher
     *
     * @mbg.generated
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.publisher
     *
     * @param publisher the value for book.publisher
     *
     * @mbg.generated
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.price
     *
     * @return the value of book.price
     *
     * @mbg.generated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.price
     *
     * @param price the value for book.price
     *
     * @mbg.generated
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.url
     *
     * @return the value of book.url
     *
     * @mbg.generated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.url
     *
     * @param url the value for book.url
     *
     * @mbg.generated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.create_time
     *
     * @return the value of book.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.create_time
     *
     * @param createTime the value for book.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.modify_time
     *
     * @return the value of book.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.modify_time
     *
     * @param modifyTime the value for book.modify_time
     *
     * @mbg.generated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.validate
     *
     * @return the value of book.validate
     *
     * @mbg.generated
     */
    public Integer getValidate() {
        return validate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.validate
     *
     * @param validate the value for book.validate
     *
     * @mbg.generated
     */
    public void setValidate(Integer validate) {
        this.validate = validate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.item_id
     *
     * @return the value of book.item_id
     *
     * @mbg.generated
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.item_id
     *
     * @param itemId the value for book.item_id
     *
     * @mbg.generated
     */
    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", promontion='" + promontion + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", validate=" + validate +
                ", itemId='" + itemId + '\'' +
                '}';
    }
}