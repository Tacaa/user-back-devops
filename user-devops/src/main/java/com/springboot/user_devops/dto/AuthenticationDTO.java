package com.springboot.user_devops.dto;


import lombok.Data;

@Data
public class AuthenticationDTO {
    private String email;
    private String password;

}