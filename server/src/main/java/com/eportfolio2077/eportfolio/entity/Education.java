package com.eportfolio2077.eportfolio.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;

    private String duration;
    private String schoolName;
    private String degree;
    private String major;
    private String minor;
    private String schoolLocation;
    private String description;
    private Long siteId;

    public Education(){}
}
