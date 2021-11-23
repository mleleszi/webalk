package hu.me.iit.webalk.demo.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class LicitEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private Integer licit;

    public LicitEntity() {
    }

    public LicitEntity(Long userId, Integer licit) {
        this.userId = userId;
        this.licit = licit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getLicit() {
        return licit;
    }

    public void setLicit(Integer licit) {
        this.licit = licit;
    }
}
