package com.bonniewhy.thechorewheel.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @NotNull
    @Size(min = 3, max = 50)
    private String password;

    private String email;

    private int points;

    @NotNull
    @Size(min = 3, max = 50)
    private String favoriteActivity;

    @ManyToMany
    private List<Room> rooms = new ArrayList<>();

    @ManyToOne
    private List<Task> tasks = new ArrayList<>();

    // Constructors
    public User() { }

    public User(String username, String password, String email, int points, String favoriteActivity) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.points = points;
        this.favoriteActivity = favoriteActivity;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getPoints() {
        return points;
    }

    public String getFavoriteActivity() {
        return favoriteActivity;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Is this how this would be done?
    public void setPoints(int newPoints) {
        this.points = points + newPoints;
    }

    public void setFavoriteActivity(String favoriteActivity) {
        this.favoriteActivity = favoriteActivity;
    }
}
