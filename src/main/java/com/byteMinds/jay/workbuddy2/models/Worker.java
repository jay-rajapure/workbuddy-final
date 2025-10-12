package com.byteMinds.jay.workbuddy2.models;

import jakarta.persistence.Entity;


@Entity
public class Worker extends Users {

    private int experienceYears;
    private int workCategory;
    private  String description;

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

    public int getWorkCategory() {
        return workCategory;
    }

    public void setWorkCategory(int workCategory) {
        this.workCategory = workCategory;
    }
}
