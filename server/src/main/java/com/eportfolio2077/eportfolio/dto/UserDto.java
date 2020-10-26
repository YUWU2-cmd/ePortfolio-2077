package com.eportfolio2077.eportfolio.dto;

import com.eportfolio2077.eportfolio.entity.User;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String profilePic;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String linkedinLink;
    private String facebookLink;
    private String twitterLink;
    private String instagramLink;
    private Long userId;

    public UserDto(User user){
        this.username=user.getUsername();
        this.profilePic=user.getProfilePicture();
        this.firstName=user.getFirstName();
        this.lastName=user.getLastName();
        this.phoneNumber=user.getPhoneNumber();
        this.linkedinLink=user.getLinkedinLink();
        this.facebookLink=user.getFacebookLink();
        this.twitterLink=user.getTwitterLink();
        this.instagramLink=user.getInstagramLink();
        this.userId=user.getUserId();
    }
}
