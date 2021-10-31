package com.sstu.work.model;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private String name;
    private String image;
    private String description;
    private String price;
    private Date date;
    private Category category;
    private SubCategory subCategory;

}
