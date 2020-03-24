package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.dto.SignUpDto;
import com.example.myfirstspringproject.models.Role;
import com.example.myfirstspringproject.models.State;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    private ExecutorService executorService;

    @Override
    public void signUp(SignUpDto form) {
        User user = User.builder()
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .firstname(form.getFirstname())
                .lastname(form.getLastname())
                .username(form.getUsername())
                .createdAt(LocalDateTime.now())
                .state(State.NOT_CONFIRMED)
                .role(Role.USER)
                .confirmCode(UUID.randomUUID().toString())
                .build();

        usersRepository.save(user);


        executorService.submit(() ->
                emailService.sendMail("Confirm", user, user.getEmail()));
    }
}


