package com.eportfolio2077.eportfolio.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long experienceId;

    private String duration;
    private String position;
    private String companyName;
    private String companyLocation;
    private String description;
    private Long siteId;

    public Experience(){}
}
