package com.byteMinds.jay.workbuddy2.Dto;

import com.byteMinds.jay.workbuddy2.models.Role;

import java.time.LocalDate;


public class UsersDto {
    protected String name;
    protected String surName;
    protected String email;
    protected Role role;
    protected byte[] profilePicture;
    protected LocalDate createdAt;

    public UsersDto(String name,String surName,String email,
                    Role role,byte[] profilePicture,LocalDate createdAt){
        this.name=name;
        this.surName = surName;
        this.email=email;
        this.role=role;
        this.profilePicture = profilePicture;
        this.createdAt= createdAt;

    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
