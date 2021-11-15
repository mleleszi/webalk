package hu.me.iit.webalk.db.service;

import hu.me.iit.webalk.db.controller.PeopleDto;
import hu.me.iit.webalk.db.repository.PeopleRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PeopleServiceImpl implements PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Iterable<People> getAllPeople() {
        /*
        List<People> rv = new ArrayList<>();

        for( hu.me.iit.webalk.db.repository.People people : peopleRepository.findAll()){
            rv.add(new People(people));
        }

        return rv;

         */
        return StreamSupport.stream(peopleRepository.findAll().spliterator(), false)
                .map(People::new)
                .collect(Collectors.toList());
    }

    @Override
    public People getById(Long id) {
        Optional<hu.me.iit.webalk.db.repository.People> optionalPeople = peopleRepository.findById(id);
        if(optionalPeople.isEmpty())
            throw new NoSuchEntityException(id);
        return new People(optionalPeople.get()); // kell a get() mert Optional
    }

    @Override
    public void save(People people) {
        Optional<hu.me.iit.webalk.db.repository.People> optionalPeople = peopleRepository.findById(people.getId());
        if(optionalPeople.isEmpty())
            throw new NoSuchEntityException(people.getId());
        peopleRepository.save(people.toEntity());
    }

    @Override
    public People create(People people) {
        return new People(peopleRepository.save(people.toEntity()));
    }

    @Override
    public void deleteById(Long id) {
        try{
            peopleRepository.deleteById(id);
        } catch(EmptyResultDataAccessException ex){
            throw new NoSuchEntityException(id);
        }

    }

}
