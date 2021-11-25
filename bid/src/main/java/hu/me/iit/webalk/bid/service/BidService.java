package hu.me.iit.webalk.bid.service;

import hu.me.iit.webalk.bid.controller.BidCreateDto;

public interface BidService {
    Iterable<Bid> getAllBids();
    Bid getBidById(Long id);
    Bid save(Bid bid);
}
