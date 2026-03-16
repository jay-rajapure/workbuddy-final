package com.byteMinds.jay.workbuddy2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Worker {
    @Id
    Long id;
    private int experienceYears;
    private String workCategory;
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

    public String getWorkCategory() {
        return workCategory;
    }

    public void setWorkCategory(String workCategory ) {
        this.workCategory = workCategory;
    }
}
