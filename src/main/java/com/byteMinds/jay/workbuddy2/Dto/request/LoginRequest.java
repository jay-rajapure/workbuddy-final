package com.byteMinds.jay.workbuddy2.Dto.request;

import com.byteMinds.jay.workbuddy2.models.Role;

public class LoginRequest {
    public  String email;
    public  String password;
    public Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
