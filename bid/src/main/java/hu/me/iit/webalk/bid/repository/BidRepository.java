package hu.me.iit.webalk.bid.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface BidRepository extends PagingAndSortingRepository<BidEntity, Long> {
    long countByUserId(long userId);
    Iterable<BidEntity> findAllByUserId(long userId);
    Iterable<BidEntity> findAllByOrderByBidAsc();
    Optional<BidEntity> findTopByOrderByBidDesc();
}
