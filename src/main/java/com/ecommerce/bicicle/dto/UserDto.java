package com.ecommerce.bicicle.dto;

import com.ecommerce.bicicle.util.Constants;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


import javax.validation.constraints.NotBlank;

@JsonInclude(Include.NON_NULL)
public class UserDto implements Serializable {

    private static final long serialVersionUID = 4739506628124849700L;
    private int id;

    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private String username;
    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private String email;
    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private String password;
    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private Timestamp createdTime;
    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private String userProfileImg;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public UserDto setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public UserDto setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public String getUserProfileImg() {
        return userProfileImg;
    }

    public UserDto setUserProfileImg(String userProfileImg) {
        this.userProfileImg = userProfileImg;
        return this;
    }
}
