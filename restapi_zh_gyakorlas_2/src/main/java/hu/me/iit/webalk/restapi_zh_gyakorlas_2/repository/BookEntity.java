package hu.me.iit.webalk.restapi_zh_gyakorlas_2.repository;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class BookEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private Integer pageCount;

    public BookEntity() {
    }

    public BookEntity(Long id, String author, Integer pageCount) {
        this.id = id;
        this.author = author;
        this.pageCount = pageCount;
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
}
