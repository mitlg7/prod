package com.sstu.work.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class Item {
    private Long id;
    private String name;
    private String image;
    private Date date;
    private String description;
    private List<Product> productList;
    private List<Comment> comments;

}
