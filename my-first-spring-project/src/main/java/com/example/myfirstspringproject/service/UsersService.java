package com.example.myfirstspringproject.service;



import com.example.myfirstspringproject.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();
    UserDto getConcreteUser(Long userId);
    List<UserDto> search(String name);
    boolean checkCookie(String cookie);

}

