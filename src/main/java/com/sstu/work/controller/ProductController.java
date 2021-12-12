package com.sstu.work.controller;

import com.sstu.work.model.utils.ProductRequest;
import com.sstu.work.service.CategoryService;
import com.sstu.work.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/create")
    public String addProduct(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "create-product";
    }

    // FORMS
    @GetMapping("/{id}")
    public String getProduct(Model model, @PathVariable String id) {
        model.addAttribute(productService.getProductById(id));
        return "product";
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
