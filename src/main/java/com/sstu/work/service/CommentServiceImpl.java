package com.sstu.work.service;

import com.sstu.work.model.Comment;
import com.sstu.work.model.User;
import com.sstu.work.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void create(User user, String productId, String massage) {
        Comment comment = new Comment()
                .setAuthor(user)
                .setDate(new java.sql.Date(new Date().getTime()))
                .setMessage(massage)
                .setProductId(Integer.parseInt(productId));

        commentRepository.createComment(comment);
    }

    @Override
    public List<Comment> getCommentByProduct(String productId) {
        return commentRepository.getCommentsByProductId(Integer.parseInt(productId));
    }
}
