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
    private boolean enable;
    private Integer phoneNumber;
    private String linkedinLink;
    private String facebookLink;
    private String twitterLink;
    private String instagramLink;
    private String verifycode;
    private String firstName;
    private String lastName;

    public User() {}

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.profilePicture = null;
        this.enable = false;
        this.verifycode = null;
    }


}
