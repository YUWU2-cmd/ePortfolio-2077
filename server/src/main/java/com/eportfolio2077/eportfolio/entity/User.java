package com.eportfolio2077.eportfolio.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;

    private String email;
    private String username;
    private String password;

    public User(){};

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

}
