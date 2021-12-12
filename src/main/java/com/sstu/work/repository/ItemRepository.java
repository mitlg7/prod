package com.sstu.work.repository;

import com.sstu.work.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    @Autowired
    CommentRepository commentRepository;

    final JdbcTemplate jdbc;

    RowMapper<Item> mapper = (rs, rowNum) ->
            new Item()
                    .setId(rs.getLong("id"))
                    .setName(rs.getString("name"))
                    .setComments(commentRepository.getAllCommentsByItemId(rs.getLong("id")))
                    .setDescription(rs.getString("description"))
                    .setDate(rs.getDate("date"));

    public ItemRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Item> getAll() {
        return jdbc.query("call allItem()", mapper);
    }

    public List<Item> getAllByUserId(Long id) {
        return jdbc.query("call itemByUserId(?)", mapper, id);
    }

    public void create(Item item, Long user_id) {
        jdbc.update("call createItem(?,?,?,?,?)",
                user_id,
                item.getName(),
                item.getImage(),
                item.getDate(),
                item.getDescription());
    }

    public void delete(Long id){
        jdbc.update("call removeItem(?)", id);
    }

}
