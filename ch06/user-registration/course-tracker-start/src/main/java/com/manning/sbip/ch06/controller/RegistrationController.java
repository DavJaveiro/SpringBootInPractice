package com.manning.sbip.ch06.controller;

import com.manning.sbip.ch06.dto.UserDto;
import com.manning.sbip.ch06.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/adduser")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "add-user";
    }

    @PostMapping("/adduser")
    public String register(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-user";
        }
        userService.createUser(userDto);
        return "redirect:/adduser?success";
    }
}
