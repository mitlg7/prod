package com.sstu.work.model.utils;

import lombok.Data;

import java.sql.Date;

@Data
public class CommentRequest {
    private String authorId;
    private String producerId;
    private Date date;
    private String message;
}
