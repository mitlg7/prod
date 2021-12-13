package com.sstu.work.controller;

import com.sstu.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupplierController {
    @Autowired
    UserService userService;

    @GetMapping("/suppliers")
    public String suppliers(Model model){
        System.out.println(userService.getAll());
        model.addAttribute("users", userService.getAll());
        return "suppliers-page";
    }
}
