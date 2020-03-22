package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.models.CookieValue;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.CookieValuesRepository;
import com.example.myfirstspringproject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CookieValuesRepository cookieValuesRepository;

    @Override
    public String signIn(String email, String password) {
        User user = usersRepository.findByEmail(email);

        String value = null;
        if (user != null && user.getHashPassword().equals(password)) {
            value = UUID.randomUUID().toString();
            CookieValue cookieValue = CookieValue.builder()
                    .value(value)
                    .user(user)
                    .build();
            cookieValuesRepository.save(cookieValue);

        }

        return value;
    }
}

