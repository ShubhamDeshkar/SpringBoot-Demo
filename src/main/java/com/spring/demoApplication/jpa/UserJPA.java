package com.spring.demoApplication.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserJPA {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String role;

    // needs a default constructor
    protected UserJPA() {
    }

    public UserJPA(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
