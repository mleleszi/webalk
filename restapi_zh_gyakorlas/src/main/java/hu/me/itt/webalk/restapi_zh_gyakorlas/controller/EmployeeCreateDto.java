package hu.me.itt.webalk.restapi_zh_gyakorlas.controller;

import com.sun.istack.NotNull;
import hu.me.itt.webalk.restapi_zh_gyakorlas.service.Employee;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class EmployeeCreateDto {

    @NotEmpty
    private String name;

    @NotNull
    @Min(18)
    private Integer age;

    public EmployeeCreateDto() {
    }

    public EmployeeCreateDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Employee toEmployee(){
        return new Employee(null, name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
