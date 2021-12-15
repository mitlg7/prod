package com.sstu.work.controller;

import com.sstu.work.model.Product;
import com.sstu.work.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

@Controller
public class MainController {
    @Autowired
    ProductService productService;


    @GetMapping
    public String a(Principal user, Model model, @RequestParam(required = false) String search){
        if(search == null){
            model.addAttribute("products", productService.getAllProducts());
        }else {
            List<Product> products = productService.searchProducts(search);
            if(!CollectionUtils.isEmpty(products)){
                model.addAttribute("products", productService.searchProducts(search));
            }else {
                model.addAttribute("notfound", true);
            }
            model.addAttribute("search", search);
        }

        return "index";
    }
}
