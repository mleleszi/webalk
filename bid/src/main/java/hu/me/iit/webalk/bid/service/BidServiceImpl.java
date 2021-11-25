package hu.me.iit.webalk.bid.service;


import hu.me.iit.webalk.bid.controller.BidCreateDto;
import hu.me.iit.webalk.bid.repository.BidEntity;
import hu.me.iit.webalk.bid.repository.BidRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;

    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public Iterable<Bid> getAllBids() {
       return StreamSupport.stream(bidRepository.findAll().spliterator(), false)
                .map(Bid::new)
                .collect(Collectors.toList());
    }

    @Override
    public Bid getBidById(Long id) {
        Optional<BidEntity> optionalBidEntity = bidRepository.findById(id);
        if(optionalBidEntity.isEmpty())
            throw new NoSuchEntityException(id);
        return new Bid(optionalBidEntity.get());
    }

    @Override
    public Bid save(Bid bid) {
        return new Bid(bidRepository.save(bid.toEntity()));
    }

    @Override
    public void update(Bid bid) {
        Optional<BidEntity> optionalBidEntity = bidRepository.findById(bid.getId());
        if(optionalBidEntity.isEmpty())
            throw new NoSuchEntityException(bid.getId());
        bidRepository.save(bid.toEntity());
    }

    @Override
    public void deleteById(Long id) {
        try {
            bidRepository.deleteById(id);
        } catch(EmptyResultDataAccessException ex){
            throw new NoSuchEntityException(id);
        }
    }

}
