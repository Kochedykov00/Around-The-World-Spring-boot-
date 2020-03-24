package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.dto.ProfileDto;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

@Service
public class EditorProfileServiceImpl implements EditorProfileService {

@Autowired
    UsersRepository usersRepository;

    @Override
    public void edit(ProfileDto profileDto, User user) {
        User userChange = User.builder()
            .firstname(profileDto.getFirstname())
                .lastname(profileDto.getLastname())
                .username(profileDto.getUsername())
                .info(profileDto.getInfo())
                .photo(profileDto.getPhoto())
                .email(user.getEmail())
                .id(user.getId())
                .confirmCode(user.getConfirmCode())
                .hashPassword(user.getHashPassword())
                .createdAt(user.getCreatedAt())
                .role(user.getRole())
                .state(user.getState())
                .build();
        usersRepository.save(userChange);
    }
}
