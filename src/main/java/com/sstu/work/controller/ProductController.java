package com.sstu.work.controller;

import com.sstu.work.model.User;
import com.sstu.work.model.utils.ProductRequest;
import com.sstu.work.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String addProduct(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return "create-product";
    }

    // FORMS
    @GetMapping("/{id}")
    public String getProduct(Model model, @PathVariable String id) {
        model.addAttribute("product",productService.getProductById(id));
        model.addAttribute("comments", commentService.getCommentByProduct(id));
        return "product";
    }

    @PostMapping("/{id}/comment")
    public String createComment( Principal principal, @PathVariable String id, String comment) {
        User user = userService.getUserByUsername(principal.getName());
        commentService.create(user,id, comment);
        return "redirect:/product/" + id ;
    }

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
        return "redirect:/product/create";
    }


    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        return null;
    }


}
