package hu.me.iit.webalk.bid.controller;


import hu.me.iit.webalk.bid.service.BidService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bid")
public class BidController {

    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @GetMapping
    public Iterable<BidDto> getAllBids(){
        List<BidDto> bidDtoList = new ArrayList<>();
        bidService.getAllBids().forEach(b -> bidDtoList.add(new BidDto(b)));
        return bidDtoList;
    }

    @GetMapping("/{id}")
    public BidDto getBidById(@PathVariable Long id){
        return new BidDto(bidService.getBidById(id));
    }

    @PostMapping(consumes = "application/json")
    public BidDto save(@RequestBody @Valid BidCreateDto bidCreateDto){
        return new BidDto(bidService.save(bidCreateDto.toBid()));
    }

    @PutMapping(consumes = "application/json")
    public void update(@RequestBody @Valid BidDto bidDto){
        bidService.update(bidDto.toBid());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        bidService.deleteById(id);
    }

    @GetMapping("/user/{userId}")
    public Iterable<BidDto> getAllBidsByUserId(@PathVariable Long userId){
        List<BidDto> bidDtoList = new ArrayList<>();
        bidService.getAllBidsByUser(userId).forEach(b -> bidDtoList.add(new BidDto(b)));
        return bidDtoList;
    }

    @GetMapping("/user/{userId}/count")
    public long countBidsByUserId(@PathVariable Long userId){
        return bidService.countBidsByUserid(userId);
    }

    @GetMapping("/sorted")
    public Iterable<BidDto> getAllBidsSortedByBid(){
        List<BidDto> bidDtoList = new ArrayList<>();
        bidService.getAllBidsSorted().forEach(b -> bidDtoList.add(new BidDto(b)));
        return bidDtoList;
    }

    @GetMapping("/highest")
    public BidDto getHighestBid(){
        return new BidDto(bidService.getHighestBid());
    }


}
