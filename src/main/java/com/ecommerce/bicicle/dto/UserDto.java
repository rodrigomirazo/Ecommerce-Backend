package com.ecommerce.bicicle.dto;

import com.ecommerce.bicicle.util.Constants;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude.Include;


import javax.validation.constraints.NotBlank;

@JsonInclude(Include.NON_NULL)
public class UserDto implements Serializable {

    private static final long serialVersionUID = 4739506628124849700L;
    private int id;

    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private String userName;

    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private String name;

    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private String lastname;

    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private String email;

    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private String password;

    private String uid;

    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private Timestamp createdTime;

    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private String userProfileImg;

    private String userDescription;

    @NotBlank(message = Constants.JSON_BLANK_FIELD)
    private String token;

    private List<UserAddressDto> userAddresses;

    private String content;

    private String favorites;

    private Boolean userVerified;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public UserDto setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UserDto setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getUid() {
        return uid;
    }

    public UserDto setUid(String uid) {
        this.uid = uid;
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

    public String getToken() {
        return token;
    }

    public UserDto setToken(String token) {
        this.token = token;
        return this;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public UserDto setUserDescription(String userDescription) {
        this.userDescription = userDescription;
        return this;
    }

    public List<UserAddressDto> getUserAddresses() {
        return userAddresses;
    }

    public UserDto setUserAddresses(List<UserAddressDto> userAddresses) {
        this.userAddresses = userAddresses;
        return this;
    }

    public String getContent() {
        return content;
    }

    public UserDto setContent(String content) {
        this.content = content;
        return this;
    }

    public String getFavorites() {
        return favorites;
    }

    public UserDto setFavorites(String favorites) {
        this.favorites = favorites;
        return this;
    }

    public Boolean getUserVerified() {
        return userVerified;
    }

    public UserDto setUserVerified(Boolean userVerified) {
        this.userVerified = userVerified;
        return this;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdTime=" + createdTime +
                ", userProfileImg='" + userProfileImg + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return getId() == userDto.getId() &&
                Objects.equals(getUserName(), userDto.getUserName()) &&
                Objects.equals(getName(), userDto.getName()) &&
                Objects.equals(getLastname(), userDto.getLastname()) &&
                Objects.equals(getEmail(), userDto.getEmail()) &&
                Objects.equals(getPassword(), userDto.getPassword()) &&
                Objects.equals(getCreatedTime(), userDto.getCreatedTime()) &&
                Objects.equals(getUserProfileImg(), userDto.getUserProfileImg()) &&
                Objects.equals(getToken(), userDto.getToken());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getName(), getLastname(), getEmail(), getPassword(), getCreatedTime(), getUserProfileImg(), getToken());
    }
}
