package com.sstu.work.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Comment {
    private Long id;
    private Date date;
    private User author;
    private String message;
}
