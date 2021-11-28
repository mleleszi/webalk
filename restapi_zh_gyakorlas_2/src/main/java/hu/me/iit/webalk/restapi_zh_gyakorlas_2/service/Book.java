package hu.me.iit.webalk.restapi_zh_gyakorlas_2.service;

import hu.me.iit.webalk.restapi_zh_gyakorlas_2.repository.BookEntity;

public class Book {
    private Long id;
    private String author;
    private Integer pageCount;

    public Book() {
    }

    public Book(Long id, String author, Integer pageCount) {
        this.id = id;
        this.author = author;
        this.pageCount = pageCount;
    }

    public Book(BookEntity bookEntity) {
        this.id = bookEntity.getId();
        this.author = bookEntity.getAuthor();
        this.pageCount = bookEntity.getPageCount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public BookEntity toEntity(){
        return new BookEntity(id, author, pageCount);
    }
}
