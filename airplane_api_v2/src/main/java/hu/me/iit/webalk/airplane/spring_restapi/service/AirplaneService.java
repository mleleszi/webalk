package hu.me.iit.webalk.airplane.spring_restapi.service;


public interface AirplaneService {

    void save(Airplane airplane);
    Airplane getById(Long id);
    Iterable<Airplane> getAllAirplanes();
    Airplane create(Airplane airplane);
    void deleteById(Long id);
}
