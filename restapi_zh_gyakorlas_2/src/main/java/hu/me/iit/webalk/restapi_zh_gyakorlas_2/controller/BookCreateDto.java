package hu.me.iit.webalk.restapi_zh_gyakorlas_2.controller;

import hu.me.iit.webalk.restapi_zh_gyakorlas_2.service.Book;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class BookCreateDto {

    @NotEmpty
    private String author;

    @Min(1)
    @NotNull
    private Integer pageCount;

    public BookCreateDto() {
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
        return new Book(null, author, pageCount);
    }

}
