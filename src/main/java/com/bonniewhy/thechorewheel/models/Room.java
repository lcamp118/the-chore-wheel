package com.bonniewhy.thechorewheel.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany
    private List<User> users;

    @ManyToOne
    private List<Task> tasks;

    // Constructors
    public Room() { }

    public Room(String name) {
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getUsers() {
        return users;
    }

    public Task getTasks() {
        return tasks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

}
