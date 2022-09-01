package com.taskplanner.users.entities;

import java.time.LocalDate;
import java.util.UUID;

/**
 * @author Laura Garcia
 */
public class User {
    private String id;
    private String name;
    private String email;
    private String lastName;
    private String createdAt;


    public User(){
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.createdAt = LocalDate.now().toString();
    }

    public User(String id, String name, String email) {
        this();
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(String id, String name, String email, String lastName, String createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.createdAt = createdAt;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
