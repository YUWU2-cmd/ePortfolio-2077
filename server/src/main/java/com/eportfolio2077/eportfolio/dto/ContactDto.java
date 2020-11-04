package com.eportfolio2077.eportfolio.dto;

import lombok.Data;

@Data
public class ContactDto {
    private String viewerEmail;
    private String ownerEmail;
    private String name;
    private String phone;
    private String content;
}
