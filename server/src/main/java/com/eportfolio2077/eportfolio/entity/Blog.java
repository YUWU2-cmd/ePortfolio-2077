package com.eportfolio2077.eportfolio.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;

    private String title;
    private String content;
    private Date createdTime;

    @ManyToOne
    @JoinColumn(name = "SiteId")
    private Site site;

    public Blog() {
        this.title="";
        this.content="";
        this.createdTime=new Date();
    };

    public Blog(String title, String content) {
        this.title= title;
        this.content= content;
        this.createdTime=new Date();
    };

}
