package hu.me.iit.webalk.bid.controller;

import hu.me.iit.webalk.bid.repository.BidEntity;
import hu.me.iit.webalk.bid.service.Bid;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BidDto {

    @NotNull
    @Min(1)
    private Long id;

    @NotNull
    @Min(1)
    private Long userId;

    @NotNull
    @Min(1)
    private Long bid;

    public BidDto() {
    }

    public BidDto(Long id, Long userId, Long bid) {
        this.id = id;
        this.userId = userId;
        this.bid = bid;
    }

    public BidDto(Bid bid) {
        this.id = bid.getId();
        this.userId = bid.getUserId();
        this.bid = bid.getBid();
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

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Bid toBid(){
        return new Bid(id, userId, bid);
    }
}

