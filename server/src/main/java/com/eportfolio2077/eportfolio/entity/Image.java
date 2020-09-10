package com.eportfolio2077.eportfolio.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long imageId;

    String imageName;
    String imagePath;
    Long userId;

    public Image() {}

    public Image(Long userId) {
        this.imageName = "";
        this.imagePath = "";
        this.userId = userId;
    }

    public Image(String imageName, String imagePath, Long userId) {
        this.imageName = imageName;
        this.imagePath = imagePath;
        this.userId = userId;
    }

    public Image(String imageName, String imagePath) {
        this.imageName = imageName;
        this.imagePath = imagePath;
    }
}
