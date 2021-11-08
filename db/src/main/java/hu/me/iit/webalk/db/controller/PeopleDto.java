package hu.me.iit.webalk.db.controller;


import hu.me.iit.webalk.db.service.People;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PeopleDto {

    private Long id;
    @NotEmpty
    private String name;
    @Min(18)
    private int age;

    public PeopleDto() {
    }

    public PeopleDto(People people) {
        this.id = people.getId();
        this.name = people.getName();
        this.age = people.getAge();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
