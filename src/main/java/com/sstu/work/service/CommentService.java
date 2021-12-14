package com.sstu.work.service;

import com.sstu.work.model.Comment;
import com.sstu.work.model.User;

import java.util.List;

public interface CommentService {
    void create(User user, String productId, String massage);
    List<Comment> getCommentByProduct(String productId);
}
