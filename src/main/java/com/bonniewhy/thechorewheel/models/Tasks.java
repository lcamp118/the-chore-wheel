package com.bonniewhy.thechorewheel.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Tasks {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    // Figure out how to better do the checkboxes? Maybe write it down on paper, and fix it.
    private boolean checked;

    // Figure out how to auto save date for when last completed.

    // Figure out how to hook up the relational databases better.

    public Tasks(String name) {
        this.name = name;
        this.checked = false;
    }

    public Tasks() { }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getChecked() {
        return checked;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setChecked() {
        this.checked = true;
    }



}
