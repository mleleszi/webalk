package hu.me.iit.webalk.restapi_zh_gyakorlas_2.controller;

import hu.me.iit.webalk.restapi_zh_gyakorlas_2.service.Book;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BookDto {

    @Min(1)
    @NotNull
    private Long id;

    @NotEmpty
    private String author;

    @Min(1)
    @NotNull
    private Integer pageCount;

    public BookDto() {
    }

    public BookDto(Long id, String author, Integer pageCount) {
        this.id = id;
        this.author = author;
        this.pageCount = pageCount;
    }

    public BookDto(Book book) {
        this.id = book.getId();
        this.author = book.getAuthor();
        this.pageCount = book.getPageCount();
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

    public Book toBook(){
        return new Book(id, author, pageCount);
    }
}
