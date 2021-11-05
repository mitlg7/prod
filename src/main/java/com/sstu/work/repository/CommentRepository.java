package com.sstu.work.repository;

import com.sstu.work.model.Comment;
import com.sstu.work.model.utils.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
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
                    .setAuthor(userRepository.getUserById(rs.getLong("user_id")));

    public CommentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Comment> getAllCommentsByItemId(Long id){
        String sql = "select * from comment where item_id = " + id;
        return jdbc.query(sql, mapper);
    }

    public void createComment(CommentRequest comment){
        //todo
    }
}
