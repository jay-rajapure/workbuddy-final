package com.byteMinds.jay.workbuddy2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private int experienceYears;
    private String workCategory;
    private  String description;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name= "user_id")
    Users user;

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkCategory() {
        return workCategory;
    }

    public void setWorkCategory(String workCategory ) {
        this.workCategory = workCategory;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
