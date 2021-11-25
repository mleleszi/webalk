package hu.me.iit.webalk.bid.service;

import hu.me.iit.webalk.bid.repository.BidEntity;

public class Bid {

    private Long id;
    private Long userId;
    private Long bid;

    public Bid() {
    }

    public Bid(Long id, Long userId, Long bid) {
        this.id = id;
        this.userId = userId;
        this.bid = bid;
    }

    public Bid(BidEntity bidEntity) {
        this.id = bidEntity.getId();
        this.userId = bidEntity.getUserId();
        this.bid = bidEntity.getBid();
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

    public BidEntity toEntity(){
        return new BidEntity(id, userId, bid);
    }
}
