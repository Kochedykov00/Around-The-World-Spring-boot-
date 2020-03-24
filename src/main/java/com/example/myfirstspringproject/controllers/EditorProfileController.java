package com.example.myfirstspringproject.controllers;


import com.example.myfirstspringproject.dto.ProfileDto;
import com.example.myfirstspringproject.security.details.UserDetailsImpl;
import com.example.myfirstspringproject.service.EditorProfileService;
import com.example.myfirstspringproject.service.EditorProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditorProfileController {

@Autowired
    private EditorProfileService profileService;


@GetMapping("/editProfile")
    public String getEditPage(Authentication authentication, Model model) {
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    model.addAttribute("user", userDetails.getUser());
    return "edit_profile";
}

@PostMapping("/editProfile")
    public String editPage(Authentication authentication, ProfileDto profileDto) {
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    profileService.edit(profileDto, userDetails.getUser());
    return "redirect:/";
}


}
