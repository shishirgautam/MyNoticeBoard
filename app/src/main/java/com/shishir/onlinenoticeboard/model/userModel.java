package com.shishir.onlinenoticeboard.model;

public class userModel {
    private String email;
    private String password;

    public userModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
