package com.spring.demoApplication.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;


public class User {

    private Integer id;

    @NotNull(message = "Cannot be null")
    @Size(min = 2, message = "Minimum 2 characters required")
    private String name;

    @NotNull
    @Past(message = "has to be in the past")
    private Date birthDate;

    public User() {
    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
