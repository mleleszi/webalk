package hu.me.iit.webalk.bid.repository;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bid")
public class BidEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long bid;

    public BidEntity() {
    }

    public BidEntity(Long id, Long userId, Long bid) {
        this.id = id;
        this.userId = userId;
        this.bid = bid;
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
}
