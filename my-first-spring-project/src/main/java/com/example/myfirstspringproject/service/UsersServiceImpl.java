package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.dto.UserDto;
import com.example.myfirstspringproject.models.CookieValue;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.CookieValuesRepository;
import com.example.myfirstspringproject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.myfirstspringproject.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private CookieValuesRepository cookieValuesRepository;

    @Override
    public List<UserDto> getUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public UserDto getConcreteUser(Long userId) {
        User user = usersRepository.getOne(userId);
        return from(user);
    }

    @Override
    public List<UserDto> search(String name) {
        return from(usersRepository.findAllByUsernameContainsIgnoreCase(name));
    }

    @Override
        public boolean checkCookie(String cookie) throws NullPointerException {
        com.example.myfirstspringproject.models.CookieValue cookieValue = cookieValuesRepository.findByValue(cookie);
        return cookieValue != null;
        }
    }


