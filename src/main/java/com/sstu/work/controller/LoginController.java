package com.sstu.work.controller;

import com.sstu.work.model.utils.RegistrationRequest;
import com.sstu.work.service.UserService;
import org.apache.catalina.loader.ResourceEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(Model model){

        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("moder"));
        System.out.println(passwordEncoder.encode("user"));
        return "login";
    }

    @PostMapping("/registration")
    public String registration(RegistrationRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        userService.createUser(request);
        return "redirect:/user/info";
    }
    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }
}
