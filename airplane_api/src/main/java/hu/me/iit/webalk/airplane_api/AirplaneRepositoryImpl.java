package hu.me.iit.webalk.airplane_api;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AirplaneRepositoryImpl implements AirplaneRepository {

    private final List<AirplaneDto> airplanes = new ArrayList<>();

    private int findAirplaneById(Long id){
        int found = -1;
        for (int i = 0; i < airplanes.size(); i++){
            if(airplanes.get(i).getId().equals(id)){
                found = i;
                break;
            }
        }
        return found;
    }

    @Override
    public List<AirplaneDto> findAll() {
        return airplanes;
    }

    @Override
    public AirplaneDto getById(Long id) {
        return null;
    }

    @Override
    public Long save(AirplaneDto airplaneDto) {
       int found = findAirplaneById(airplaneDto.getId());

       if(found != -1) {
           AirplaneDto foundAirplane = airplanes.get(found);
           foundAirplane.setModelNumber(airplaneDto.getModelNumber());
           foundAirplane.setManufacturer(airplaneDto.getManufacturer());
           foundAirplane.setAirline(airplaneDto.getAirline());
           foundAirplane.setCapacity(airplaneDto.getCapacity());
       } else {
           airplanes.add(airplaneDto);
       }

       return null;
    }

    @Override
    public void deleteById(Long id) {
        int found = findAirplaneById(id);

        if(found != -1) {
            airplanes.remove(found);
        }
    }
}
