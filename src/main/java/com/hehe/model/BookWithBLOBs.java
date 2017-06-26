package com.hehe.model;

public class BookWithBLOBs extends Book {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.brief
     *
     * @mbg.generated
     */
    private String brief;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.author_brief
     *
     * @mbg.generated
     */
    private String authorBrief;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.catalog
     *
     * @mbg.generated
     */
    private String catalog;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.digest
     *
     * @mbg.generated
     */
    private String digest;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.brief
     *
     * @return the value of book.brief
     * @mbg.generated
     */
    public String getBrief() {
        return brief;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.brief
     *
     * @param brief the value for book.brief
     * @mbg.generated
     */
    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.author_brief
     *
     * @return the value of book.author_brief
     * @mbg.generated
     */
    public String getAuthorBrief() {
        return authorBrief;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.author_brief
     *
     * @param authorBrief the value for book.author_brief
     * @mbg.generated
     */
    public void setAuthorBrief(String authorBrief) {
        this.authorBrief = authorBrief == null ? null : authorBrief.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.catalog
     *
     * @return the value of book.catalog
     * @mbg.generated
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.catalog
     *
     * @param catalog the value for book.catalog
     * @mbg.generated
     */
    public void setCatalog(String catalog) {
        this.catalog = catalog == null ? null : catalog.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.digest
     *
     * @return the value of book.digest
     * @mbg.generated
     */
    public String getDigest() {
        return digest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.digest
     *
     * @param digest the value for book.digest
     * @mbg.generated
     */
    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}