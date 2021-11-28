package hu.me.iit.webalk.bid.service;

import hu.me.iit.webalk.bid.controller.BidCreateDto;
import hu.me.iit.webalk.bid.controller.BidDto;

public interface BidService {
    Iterable<Bid> getAllBids();
    Bid getBidById(Long id);
    Bid save(Bid bid);
    void update(Bid bid);
    void deleteById(Long id);

    // custom queries
    Iterable<Bid> getAllBidsByUser(Long id);
    long countBidsByUserid(Long userId);
    Iterable<Bid> getAllBidsSorted();
    Bid getHighestBid();
}
