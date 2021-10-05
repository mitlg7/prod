package com.sstu.work.controller;

import com.sstu.work.model.User;
import com.sstu.work.model.utils.RegistrationRequest;
import com.sstu.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(@AuthenticationPrincipal User auth, Model model){
        return null;
    }

    @PostMapping("/logout")
    public String logout(){
        return null;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request){
        return null;
    }

}
