package com.sstu.work.model;

import java.util.List;

public class Item {
    private Long id;
    private String name;
    private User producer;
    private String rating;
    private String phone;
    private String address;

    private List<Product> productList;
    private List<Comment> comments;

}
