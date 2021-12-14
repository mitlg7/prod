package com.sstu.work.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@Accessors(chain = true)
public class Comment {
    private Long id;
    private Date date;
    private User author;
    private String message;
    private int productId;

}
