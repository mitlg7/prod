package com.sstu.work.controller;

import com.sstu.work.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {
    @Autowired
    ProductService productService;


    @GetMapping
    public String a(Principal user, Model model){
        System.out.println(productService.getAllProducts());
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }
}
