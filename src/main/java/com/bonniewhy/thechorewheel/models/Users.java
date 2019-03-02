package com.bonniewhy.thechorewheel.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Users {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @NotNull
    @Size(min = 3, max = 50)
    private String password;

    @NotNull
    @Size(min = 3, max = 50)
    private String favoriteActivity;

    @OneToMany
    @JoinColumn(name = "room_id")
    private List<Rooms> rooms = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "task_id")
    private List<Tasks> tasks = new ArrayList<>();

    public Users(String username, String password, String favoriteActivity) {
        this.username = username;
        this.password = password;
        this.favoriteActivity = favoriteActivity;
    }

    public Users() { }

    // Getters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFavoriteActivity() {
        return favoriteActivity;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFavoriteActivity(String favoriteActivity) {
        this.favoriteActivity = favoriteActivity;
    }

}
