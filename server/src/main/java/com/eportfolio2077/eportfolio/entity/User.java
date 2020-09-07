package com.eportfolio2077.eportfolio.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String role;
    private String username;
    private String password;

    public User(String email, String role, String username, String password) {
        this.email = email;
        this.role = role;
        this.username = username;
        this.password = password;
    }

}
