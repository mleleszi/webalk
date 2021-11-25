package hu.me.iit.webalk.bid.controller;

import hu.me.iit.webalk.bid.service.Bid;
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
}
