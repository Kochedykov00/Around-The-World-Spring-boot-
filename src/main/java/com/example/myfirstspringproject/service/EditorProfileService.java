package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.dto.ProfileDto;
import com.example.myfirstspringproject.models.User;

public interface EditorProfileService {

    public void edit(ProfileDto profileDto, User user);
}
