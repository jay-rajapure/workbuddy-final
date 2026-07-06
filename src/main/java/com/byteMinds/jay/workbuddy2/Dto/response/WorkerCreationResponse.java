package com.byteMinds.jay.workbuddy2.Dto.response;

public class WorkerCreationResponse {

    public SimpleResponse simpleResponse;
    public int experienceYears;
    public String workCategory;
    public   String description;
    public UsersResponse usersResponse;

    public SimpleResponse getSimpleResponse() {
        return simpleResponse;
    }

    public void setSimpleResponse(SimpleResponse simpleResponse) {
        this.simpleResponse = simpleResponse;
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

    public UsersResponse getUsersResponse() {
        return usersResponse;
    }

    public void setUsersResponse(UsersResponse usersResponse) {
        this.usersResponse = usersResponse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
