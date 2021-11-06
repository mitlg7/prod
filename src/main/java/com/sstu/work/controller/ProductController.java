package com.sstu.work.controller;

import com.sstu.work.model.Product;
import com.sstu.work.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;


    // FORMS
    @GetMapping("/{id}")
    public String getProduct(@PathVariable String id) {
        return "product";
    }

    @GetMapping("/all")
    public String getAllProduct(@RequestParam(required = false) String user) {
        if (user != null) {
            //TODO получить айтемы юзера(поставщика) иначе все вообще, еще сделать фильтр потом
        }else {

        }
        return null;
    }
    /////////////////////////////
    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {

    }



    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        return null;
    }



}
