package com.example.myfirstspringproject.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
}

