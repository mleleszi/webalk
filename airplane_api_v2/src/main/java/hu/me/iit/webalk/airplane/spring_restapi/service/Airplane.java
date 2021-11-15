package hu.me.iit.webalk.airplane.spring_restapi.service;

import hu.me.iit.webalk.airplane.spring_restapi.repository.AirplaneEntity;

public class Airplane {

    private Long id;
    private String manufacturer;
    private String modelNumber;
    private String airline;
    private int capacity;

    public Airplane() {
    }

    public Airplane(Long id, String manufacturer, String modelNumber, String airline, int capacity) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.modelNumber = modelNumber;
        this.airline = airline;
        this.capacity = capacity;
    }

    public Airplane(AirplaneEntity airplaneEntity){
        this.id = airplaneEntity.getId();
        this.manufacturer = airplaneEntity.getManufacturer();
        this.modelNumber = airplaneEntity.getModelNumber();
        this.airline = airplaneEntity.getAirline();
        this.capacity = airplaneEntity.getCapacity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public AirplaneEntity toEntity(){
        return new AirplaneEntity(id, manufacturer, modelNumber, airline, capacity);
    }
}
