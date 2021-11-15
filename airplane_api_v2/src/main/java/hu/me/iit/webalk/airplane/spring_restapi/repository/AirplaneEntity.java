package hu.me.iit.webalk.airplane.spring_restapi.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class AirplaneEntity {


    @Id
    @GeneratedValue
    private Long id;

    private String manufacturer;
    private String modelNumber;
    private String airline;
    private int capacity;

    public AirplaneEntity() {
    }

    public AirplaneEntity(Long id, String manufacturer, String modelNumber, String airline, int capacity) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.modelNumber = modelNumber;
        this.airline = airline;
        this.capacity = capacity;
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
}
