package com.sstu.work.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Product {
    private Long id;
    private Long userId;
    private String name;
    private String image;
    private String description;
    private Long price;
    private Date date;
    private Category category;
    private SubCategory subCategory;

}
