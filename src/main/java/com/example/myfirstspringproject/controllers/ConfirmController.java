package com.example.myfirstspringproject.controllers;


import com.example.myfirstspringproject.service.ConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ConfirmController {

    @Autowired
    private ConfirmService confirmService;

    @GetMapping("/confirm/{confirm-code}")
    public String confirm(@PathVariable("confirm-code") String confirmCode,
                          Model model) {
        boolean isConfirmed = confirmService.confirm(confirmCode);
        model.addAttribute("isConfirmed", isConfirmed);
        return "confirm_page";
    }
}




