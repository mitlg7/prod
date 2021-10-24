package com.sstu.work.controller;

import com.sstu.work.model.User;
import com.sstu.work.model.utils.UserUpdateRequest;
import com.sstu.work.service.ProductService;
import com.sstu.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @PostMapping("/update")
    public String userUpdate(@AuthenticationPrincipal User user, @RequestBody UserUpdateRequest updateRequest){
        return null;
    }

    @GetMapping
    public String getUser( Model model){
        return "index";
    }

    @GetMapping("/{id}")
    public String getUserByID(@AuthenticationPrincipal User user, @PathVariable String id, Model model){
        return null;
    }

    @DeleteMapping("/{id}")
    public String remove(@AuthenticationPrincipal User user, @PathVariable String id, Model model){
        return null;
    }

}
