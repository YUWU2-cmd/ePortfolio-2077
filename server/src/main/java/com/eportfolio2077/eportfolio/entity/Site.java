package com.eportfolio2077.eportfolio.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long siteId;
    private String template;
    private String aboutMe;
    private String bio;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    public Site(){}

}
