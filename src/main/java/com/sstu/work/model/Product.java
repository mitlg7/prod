package com.sstu.work.model;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private String name;
    private ProductType type;
    private String image;
    private String description;
    private String price;
    private Date date;

}
