package com.User_Service.User_Service.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "ID")
    private String userId;
    private String name;
    private String email;
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

    // Default Constructor
    public User() {
    }

    // Constructor for Builder
    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.email = builder.email;
        this.about = builder.about;
        this.ratings = builder.ratings;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    // Static Inner Builder Class
    public static class UserBuilder {
        private String userId;
        private String name;
        private String email;
        private String about;
        private List<Rating> ratings = new ArrayList<>();

        public UserBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder about(String about) {
            this.about = about;
            return this;
        }

        public UserBuilder ratings(List<Rating> ratings) {
            this.ratings = ratings;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    // Static Method to Create Builder
    public static UserBuilder builder() {
        return new UserBuilder();
    }
}
