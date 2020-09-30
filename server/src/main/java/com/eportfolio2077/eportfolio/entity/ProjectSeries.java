package com.eportfolio2077.eportfolio.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProjectSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectSeriesId;

    private String seriesName;
    private String summary;
    private Long siteId;

    public ProjectSeries(){}
}
