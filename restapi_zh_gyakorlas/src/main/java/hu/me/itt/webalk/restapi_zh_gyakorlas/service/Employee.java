package hu.me.itt.webalk.restapi_zh_gyakorlas.service;

import hu.me.itt.webalk.restapi_zh_gyakorlas.repository.EmployeeModel;

public class Employee {
    private Long id;
    private String name;
    private Integer age;

    public Employee() {
    }

    public Employee(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Employee(EmployeeModel employeeModel) {
        this.id = employeeModel.getId();
        this.name = employeeModel.getName();
        this.age = employeeModel.getAge();
    }

    public EmployeeModel toModel(){
        return new EmployeeModel(id, name, age);
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
