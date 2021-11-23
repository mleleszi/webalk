package hu.me.iit.webalk.demo.controller;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SaveLicitDto {

    @NotNull
    @Min(1)
    private Long userId;

    @NotNull
    @Min(1)
    private Integer licit;

    public SaveLicitDto() {
    }

    public SaveLicitDto(Long userId, Integer licit) {
        this.userId = userId;
        this.licit = licit;
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
