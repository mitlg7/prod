package com.sstu.work.controller;

import com.sstu.work.model.User;
import com.sstu.work.model.utils.UserInfoRequest;
import com.sstu.work.model.utils.UserUpdateRequest;
import com.sstu.work.repository.CategoryRepository;
import com.sstu.work.service.ProductService;
import com.sstu.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepository categoryRepository;

    // FORMS
    @GetMapping
    public String user(Principal principal, Model model) {
        User user = userService.getUserByUsername(principal.getName());
        if(user.getInfo()!= null)
            model.addAttribute("userInfo", user.getInfo());
        model.addAttribute("user", user);
        return "user";
    }



    @GetMapping("/user-info")
    public String AddUserInfoForm(Model model) {
        return "create-user-info";
    }

    @GetMapping("/{id}")
    public String getUserByID(@AuthenticationPrincipal User user, @PathVariable String id, Model model) {
        return null;
    }
    //////////////////////////////

    @PostMapping("/user-info")
    public String addUserInfo(Principal principal, UserInfoRequest userInfoRequest) {
        userService.addUserInfo(userInfoRequest, principal.getName());
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String remove(@AuthenticationPrincipal User user, @PathVariable String id, Model model) {
        return null;
    }

    @PostMapping("/update")
    public String userUpdate(@AuthenticationPrincipal User user, @RequestBody UserUpdateRequest updateRequest) {
        return null;
    }
}
