package com.eportfolio2077.eportfolio.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Long userId;

    public Blog() {};

    public Blog(String title, String content, Date createdTime) {
        this.title = title;
        this.content = content;
        this.createdTime = createdTime;
    }

}
