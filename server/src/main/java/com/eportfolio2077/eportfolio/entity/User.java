package com.eportfolio2077.eportfolio.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;
    private String username;
    private String password;
    private String profilePicture;
    private String bio;
    private String aboutMe;
    private boolean enable;
    private String verifycode;

    public User() {
    }

    ;

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.profilePicture = null;
        this.bio = null;
        this.aboutMe = null;
        this.enable = false;
        this.verifycode = null;
    }


}
