package com.sstu.work.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Item {
    private Long id;
    private String name;
    private User producer;
    private String rating;
    private String phone;
    private String address;
    private Date date;
    private List<Product> productList;
    private List<Comment> comments;

}
