package com.eportfolio2077.eportfolio.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "RoleId")
    private Role role;

}
