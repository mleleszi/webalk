package hu.me.iit.webalk.demo.controller;

import hu.me.iit.webalk.demo.service.LicitService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LicitController {

    private final LicitService licitService;

    public LicitController(LicitService licitService) {
        this.licitService = licitService;
    }

    @GetMapping("/licit/highest")
    public int getHighestBid(){
        return licitService.getHighestBid();
    }

    @GetMapping("/licit/highest/{userId}")
    public int getHighestBidForUser(@PathVariable Long userId){
        return licitService.getHighestBidForUser(userId);
    }

    @PostMapping("")
    public void saveNewLicit(@RequestBody @Valid SaveLicitDto saveLicitDto){
        licitService.saveNewLicit(saveLicitDto.getUserId(), saveLicitDto.getLicit());
    }

}
