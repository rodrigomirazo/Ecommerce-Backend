package com.ecommerce.bicicle.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "uid")
    private String uid;

    @Column(name = "create_time")
    private Timestamp createdTime;

    @Column(name = "user_profile_img")
    private String userProfileImg;

    @Column(name = "user_description")
    private String userDescription;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<UserAddressEntity> userAddresses;

    @Column(name = "content")
    private String content;

    @Column(name = "favorites")
    private String favorites;

    @Column(name = "user_verified")
    private Boolean userVerified;

    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public UserEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserEntity setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public UserEntity setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public UserEntity setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public UserEntity setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public String getUserProfileImg() {
        return userProfileImg;
    }

    public UserEntity setUserProfileImg(String userProfileImg) {
        this.userProfileImg = userProfileImg;
        return this;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public UserEntity setUserDescription(String userDescription) {
        this.userDescription = userDescription;
        return this;
    }

    public List<UserAddressEntity> getUserAddresses() {
        return userAddresses;
    }

    public UserEntity setUserAddresses(List<UserAddressEntity> userAddresses) {
        this.userAddresses = userAddresses;
        return this;
    }

    public String getContent() {
        return content;
    }

    public UserEntity setContent(String content) {
        this.content = content;
        return this;
    }

    public String getFavorites() {
        return favorites;
    }

    public UserEntity setFavorites(String favorites) {
        this.favorites = favorites;
        return this;
    }

    public Boolean getUserVerified() {
        return userVerified;
    }

    public UserEntity setUserVerified(Boolean userVerified) {
        this.userVerified = userVerified;
        return this;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdTime=" + createdTime +
                ", userProfileImg='" + userProfileImg + '\'' +
                ", userDescription='" + userDescription + '\'' +
                ", userAddresses=" + userAddresses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that = (UserEntity) o;
        return getId() == that.getId() &&
                Objects.equals(getUserName(), that.getUserName()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getLastname(), that.getLastname()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getCreatedTime(), that.getCreatedTime()) &&
                Objects.equals(getUserProfileImg(), that.getUserProfileImg()) &&
                Objects.equals(getUserDescription(), that.getUserDescription()) &&
                Objects.equals(getUserAddresses(), that.getUserAddresses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getName(), getLastname(), getEmail(), getPassword(), getCreatedTime(), getUserProfileImg(), getUserDescription(), getUserAddresses());
    }
}
