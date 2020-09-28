package com.eportfolio2077.eportfolio.dto;

import com.eportfolio2077.eportfolio.entity.User;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String profilePic;
    private String bio;
    private String aboutMe;

    public UserDto(User user){
        this.username=user.getUsername();
        this.profilePic=user.getProfilePicture();
        this.bio=user.getBio();
        this.aboutMe=user.getAboutMe();
    }
}
