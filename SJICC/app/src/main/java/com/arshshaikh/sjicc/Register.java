package com.arshshaikh.sjicc;

public class Register {
    String name,email,password,roleStatus;

    public Register(String name, String email, String password, String roleStatus) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleStatus = roleStatus;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRoleStatus() {
        return roleStatus;
    }
}
