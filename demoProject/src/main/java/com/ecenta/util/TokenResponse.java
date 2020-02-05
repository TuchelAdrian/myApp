package com.ecenta.util;

public class TokenResponse {
    private Integer status;
    private String token;

    public Integer getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
