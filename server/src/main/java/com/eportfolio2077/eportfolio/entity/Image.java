package com.eportfolio2077.eportfolio.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    private String imageName;
    private String imagePath;

    @ManyToOne
    private Site site;

    public Image() {
        this.imageName = null;
        this.imagePath = null;
    }


    public Image(String imageName, String imagePath) {
        this.imageName = imageName;
        this.imagePath = imagePath;
    }
}
