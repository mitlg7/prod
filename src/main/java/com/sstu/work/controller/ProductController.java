package com.sstu.work.controller;

import com.sstu.work.model.User;
import com.sstu.work.model.utils.ProductRequest;
import com.sstu.work.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;
    @Autowired
    CountryService countryService;

    @GetMapping("/create")
    public String addProduct(Principal principal, Model model) {
        User user= userService.getUserByUsername(principal.getName());
        if(user != null && user.getRole().getType().equals("USER")){
            return "redirect:/";
        }
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return "create-product";
    }

    // FORMS
    @GetMapping("/{id}")
    public String getProduct(Principal principal, Model model, @PathVariable String id) {
        if(principal!= null){
            User user = userService.getUserByUsername(principal.getName());
            model.addAttribute("user", user);
        }
        model.addAttribute("product",productService.getProductById(id));
        model.addAttribute("comments", commentService.getCommentByProduct(id));

        return "product";
    }
    @PreAuthorize("hasAnyRole('ADMIN','MODER')")
    @PostMapping("/{id}/comment")
    public String createComment( Principal principal, @PathVariable String id, String comment) {
        User user = userService.getUserByUsername(principal.getName());
        commentService.create(user,id, comment);
        return "redirect:/product/" + id ;
    }
    @PreAuthorize("hasAnyRole('ADMIN','MODER')")
    @PostMapping("/delete")
    public String removeProduct(Long id) {
        productService.removeProduct(id);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String getAllProduct(@RequestParam(required = false) String user) {
        if (user != null) {
            //TODO получить айтемы юзера(поставщика) иначе все вообще, еще сделать фильтр потом
        } else {

        }
        return null;
    }

    @PostMapping("/create")
    public String addProduct(Principal principal, ProductRequest productRequest) {
        productService.createProduct(principal.getName(), productRequest);
        return "redirect:/user";
    }


    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        return null;
    }


}
