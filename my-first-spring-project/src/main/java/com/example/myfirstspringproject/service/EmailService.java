package com.example.myfirstspringproject.service;


import com.example.myfirstspringproject.models.User;

public interface EmailService {
    public void sendMail(String subject, User user, String email);
}

