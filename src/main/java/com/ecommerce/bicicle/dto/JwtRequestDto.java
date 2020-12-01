package com.ecommerce.bicicle.dto;

public class JwtRequestDto {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public JwtRequestDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public JwtRequestDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
