package com.sstu.work.repository;

import com.sstu.work.model.Comment;
import com.sstu.work.model.utils.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {

    @Autowired
    UserRepository userRepository;

    final JdbcTemplate jdbc;

    RowMapper<Comment> mapper = (rs, rowNum) ->
            new Comment()
                    .setId(rs.getLong("id"))
                    .setDate(rs.getDate("date"))
                    .setMessage(rs.getString("message"))
                    .setAuthor(userRepository.getUserById(rs.getLong("user_id")))
                    .setProductId(rs.getInt("product_id"));

    public CommentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Comment> getCommentsByProductId(int id) {
        return jdbc.query("call commentByProductId(?)", mapper, id);
    }

    public void createComment(Comment comment) {
        jdbc.update("call createComment(?,?,?,?)",
                comment.getAuthor().getId(),
                comment.getDate(),
                comment.getMessage(),
                comment.getProductId()
        );

    }
}
