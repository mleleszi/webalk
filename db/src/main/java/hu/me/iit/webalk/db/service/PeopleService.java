package hu.me.iit.webalk.db.service;


import hu.me.iit.webalk.db.controller.PeopleCreateDto;

public interface PeopleService {
    Iterable<People> getAllPeople();

    People create(People toPeople);

    void deleteById(Long id);

    People getById(Long id);

    void save(People people);
}
