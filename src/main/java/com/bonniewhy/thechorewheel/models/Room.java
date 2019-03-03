package com.bonniewhy.thechorewheel.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @ManyToMany(mappedBy = "rooms")
    private List<User> users;

    @OneToMany
    @JoinColumn(name = "room_id")
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

    public List<User> getUsers() {
        return users;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

}
