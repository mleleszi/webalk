package hu.me.iit.webalk.airplane.spring_restapi.controller;

import hu.me.iit.webalk.airplane.spring_restapi.service.AirplaneService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {
    private final AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @GetMapping
    public Iterable<AirplaneDto> getAllAirplanes(){
        List<AirplaneDto> airplaneDtoList = new ArrayList<>();
        airplaneService.getAllAirplanes().forEach((a) -> airplaneDtoList.add(new AirplaneDto(a)));
        return airplaneDtoList;
    }

    @GetMapping("/{id}")
    public AirplaneDto getAirplaneById(@PathVariable Long id){
        return new AirplaneDto(airplaneService.getById(id));
    }

    @PostMapping(consumes = "application/json")
    public AirplaneDto save(@RequestBody @Valid AirplaneCreateDto airplaneCreateDto){
        return new AirplaneDto(airplaneService.create(airplaneCreateDto.toAirplane()));
    }

    @PutMapping
    public void save(@RequestBody @Valid AirplaneDto airplaneDto){
        airplaneService.save(airplaneDto.toAirplane());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        airplaneService.deleteById(id);
    }


}
