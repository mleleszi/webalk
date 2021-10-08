package hu.me.iit.webalk.airplane_api;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AirplaneDto {

    @NotNull
    private Long id;
    @NotNull
    private Long modelNumber;
    @NotBlank
    private String manufacturer;
    @NotBlank
    private String airline;
    @Min(1)
    private Integer capacity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(Long modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "AirplaneDto{" +
                "id=" + id +
                ", modelNumber=" + modelNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", airline='" + airline + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
