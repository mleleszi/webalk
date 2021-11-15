package hu.me.iit.webalk.airplane.spring_restapi.service;

import hu.me.iit.webalk.airplane.spring_restapi.repository.AirplaneEntity;
import hu.me.iit.webalk.airplane.spring_restapi.repository.AirplaneRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;

    public AirplaneServiceImpl(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public Airplane create(Airplane airplane) {
        return new Airplane(airplaneRepository.save(airplane.toEntity()));
    }

    @Override
    public Airplane getById(Long id) {
        Optional<AirplaneEntity> optionalAirplaneEntity = airplaneRepository.findById(id);
        if (optionalAirplaneEntity.isEmpty())
            throw new NoSuchEntityException(id);
        return new Airplane(optionalAirplaneEntity.get());
    }

    @Override
    public Iterable<Airplane> getAllAirplanes() {
       return StreamSupport.stream(airplaneRepository.findAll().spliterator(), false)
                .map(Airplane::new)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Airplane airplane) {
        Optional<AirplaneEntity> optionalAirplaneEntity = airplaneRepository.findById(airplane.getId());
        if(optionalAirplaneEntity.isEmpty())
            throw new NoSuchEntityException(airplane.getId());
        airplaneRepository.save(airplane.toEntity());
    }

    @Override
    public void deleteById(Long id) {
        try{
            airplaneRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex){
            throw new NoSuchEntityException(id);
        }
    }
}
