package hu.me.iit.webalk.db.controller;

import hu.me.iit.webalk.db.service.People;
import hu.me.iit.webalk.db.service.PeopleService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public Iterable<PeopleDto> getAllPeople() {
      List<PeopleDto> peopleDtoList = new ArrayList<>();
      for(People people :  peopleService.getAllPeople()){
          peopleDtoList.add(new PeopleDto(people));
      }

      return peopleDtoList;
    }

    @GetMapping("/{id}")
    public PeopleDto getById(@PathVariable Long id){
        return new PeopleDto(peopleService.getById(id));
    }

    @PostMapping(consumes = "application/json")
    public PeopleDto save(@RequestBody @Valid PeopleCreateDto peopleCreateDto){
       return new PeopleDto(peopleService.create(peopleCreateDto.toPeople()));
    }

    @PutMapping
    public void save(@RequestBody @Valid PeopleDto peopleDto){
        peopleService.save(peopleDto.toPeople());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        peopleService.deleteById(id);
    }



}
