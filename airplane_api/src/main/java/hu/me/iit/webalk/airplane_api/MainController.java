package hu.me.iit.webalk.airplane_api;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path="airplane")
public class MainController {

    private final AirplaneService airplaneService;

    public MainController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @GetMapping(path = "")
    public List<AirplaneDto> allAirplanes() {
        return airplaneService.findAll();
    }

    @PostMapping(path = "")
    public void newAirplane(@RequestBody @Valid AirplaneDto airplaneDto) {
        airplaneService.save(airplaneDto);
    }

    @PutMapping(path = "")
    public void replaceAirplane(@RequestBody @Valid AirplaneDto airplaneDto){
        airplaneService.save(airplaneDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAirplane(@PathVariable("id") Long id){
        airplaneService.deleteById(id);
    }
}
