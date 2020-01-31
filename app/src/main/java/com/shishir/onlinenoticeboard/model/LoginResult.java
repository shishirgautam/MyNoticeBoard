package com.shishir.onlinenoticeboard.model;

public class LoginResult {
    private String token;
    private String status;

    public LoginResult( String status,String token) {
        this.status = status;
        this.token = token;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
