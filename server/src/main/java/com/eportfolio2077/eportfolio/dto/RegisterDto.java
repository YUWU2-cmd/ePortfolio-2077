package com.eportfolio2077.eportfolio.dto;

import lombok.Data;

@Data
public class RegisterDto extends LoginDto {
    private String email;
    private String role;
}
