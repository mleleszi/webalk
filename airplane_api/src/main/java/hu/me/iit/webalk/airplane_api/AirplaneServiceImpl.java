package hu.me.iit.webalk.airplane_api;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirplaneServiceImpl implements AirplaneService {

    private final int MAXIMUM_AIRPLANE_COUNT = 10;
    private final AirplaneRepository airplaneRepository;

    public AirplaneServiceImpl(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public List<AirplaneDto> findAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public AirplaneDto getById(Long id) {
        return airplaneRepository.getById(id);
    }

    @Override
    public Long save(AirplaneDto airplaneDto) {
        if(airplaneRepository.findAll().size() >= MAXIMUM_AIRPLANE_COUNT) {
            throw new TooManyAirplanesException();
        }
        return airplaneRepository.save(airplaneDto);
    }

    @Override
    public void deleteById(Long id) {
        airplaneRepository.deleteById(id);
    }
}
