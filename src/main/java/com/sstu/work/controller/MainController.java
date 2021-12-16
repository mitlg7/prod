package com.sstu.work.controller;

import com.sstu.work.model.Product;
import com.sstu.work.service.CategoryService;
import com.sstu.work.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String a(Principal user, Model model,
                    @RequestParam(required = false) String search,
                    @RequestParam(required = false) String cat) {
        if (search == null && cat == null) {
            model.addAttribute("products", productService.getAllProducts());
        } else {
            List<Product> products = productService.getAllProducts();

            if(search != null){
                products = productService.searchProducts(search);
                if (!CollectionUtils.isEmpty(products)) {
                    ;
                } else {
                    model.addAttribute("notfound", true);
                }
                model.addAttribute("search", search);
            }
            if (cat != null) {
                model.addAttribute("catId",Long.parseLong( cat));
                products = products.stream().filter(product -> product.getCategory().getId().equals(Long.parseLong(cat))).collect(Collectors.toList());
            }
            model.addAttribute("products", products);
            model.addAttribute("search", search);

        }
        System.out.println(categoryService.getAll());
        model.addAttribute("cats", categoryService.getAll());
        return "index";
    }
}
