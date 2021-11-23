package hu.me.iit.webalk.demo.service;

public interface LicitService {
    int getHighestBid();

    int getHighestBidForUser(Long id);

    void saveNewLicit(Long userId, Integer licit);
}
