package com.byteMinds.jay.workbuddy2.Dto;

import com.byteMinds.jay.workbuddy2.models.Role;

import java.time.LocalDate;

public class WorkerResponse extends UsersDto{
    private int experienceYears;
    private String workCategory;
    private  String description;

    public  WorkerResponse(String name, String surname, String email,
                           Role role, byte[] profilePicture, LocalDate createdAt, int experienceYears, String workCategory, String description)
    {
        super(name,surname,email,role,profilePicture,createdAt);
        this.experienceYears=experienceYears;
        this.workCategory= workCategory;
        this.description= description;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getWorkCategory() {
        return workCategory;
    }

    public void setWorkCategory(String workCategory) {
        this.workCategory = workCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
