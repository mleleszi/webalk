package hu.me.iit.webalk.airplane_api;

import java.util.List;

public interface AirplaneRepository {
    List<AirplaneDto> findAll();
    AirplaneDto getById(Long id);
    Long save(AirplaneDto airplaneDto);
    void deleteById(Long id);
}
