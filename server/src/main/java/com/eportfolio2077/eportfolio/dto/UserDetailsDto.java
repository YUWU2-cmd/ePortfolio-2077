package com.eportfolio2077.eportfolio.dto;

import lombok.Data;

@Data
public class UserDetailsDto {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String LinkedinLink;
    private String facebookLink;
    private String twitterLink;
    private String instagramLink;
    private Long userId;
}
