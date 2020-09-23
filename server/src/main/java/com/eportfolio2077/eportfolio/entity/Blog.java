package com.eportfolio2077.eportfolio.entity;

import com.eportfolio2077.eportfolio.dto.BlogDto;
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
    private Site site;

    public Blog() {
        this.title="";
        this.content="";
        this.createdTime=new Date();
    };

    public Blog(BlogDto blogDto) {
        this.title= blogDto.getTitle();
        this.content= blogDto.getContent();
        this.createdTime=new Date();
    };

}
