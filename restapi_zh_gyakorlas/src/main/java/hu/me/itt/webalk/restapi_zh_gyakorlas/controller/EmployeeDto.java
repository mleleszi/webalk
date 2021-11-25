package hu.me.itt.webalk.restapi_zh_gyakorlas.controller;

import com.sun.istack.NotNull;
import hu.me.itt.webalk.restapi_zh_gyakorlas.service.Employee;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class EmployeeDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    @Min(18)
    private Integer age;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public EmployeeDto(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.age = employee.getAge();
    }

    public Employee toEmployee(){
        return new Employee(id, name, age);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
