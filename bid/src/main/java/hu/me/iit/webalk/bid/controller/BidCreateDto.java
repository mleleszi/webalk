package hu.me.iit.webalk.bid.controller;

import com.sun.istack.NotNull;
import hu.me.iit.webalk.bid.service.Bid;

import javax.validation.constraints.Min;

public class BidCreateDto {

    @NotNull
    @Min(1)
    private Long userId;

    @NotNull
    @Min(1)
    private Long bid;

    public BidCreateDto() {
    }

    public BidCreateDto(Long userId, Long bid) {
        this.userId = userId;
        this.bid = bid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Bid toBid(){
        return new Bid(null, userId, bid);
    }
}
