package com.sstu.work.repository;

import com.sstu.work.model.Role;
import com.sstu.work.model.User;
import com.sstu.work.model.utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    final JdbcTemplate jdbc;

    @Autowired
    RoleRepository roleRepository;

    RowMapper<User> mapper = (rs, rowNum) -> new User().setId(rs.getLong("id"))
            .setLogin(rs.getString("login"))
            .setEmail(rs.getString("email"))
            .setPassword(rs.getString("password"))
            .setRole(roleRepository.getById(rs.getLong("role_id")));

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private User one(String sql, String login) {
        var res = jdbc.query(sql, mapper, login);
        return res.size() == 0 ? null : res.get(0);
    }

    public List<User> getAllUsers() {
        return jdbc.query("select * from users;",
                mapper);
    }

    public User getUserByLogin(String login) {

        User user = one("select * from USER_BY_LOGIN(?)", login);
        if (user == null)
            throw new NotFoundException("User with login" + login + "not found");
        return user;
    }

    public User getUserById(Long id) {
//        String sql = "select * from users where id =" + id;
//        User user = one(sql);
//        if (user == null)
//            throw new NotFoundException("User with id" + id + "not found");
//        return user;
        return new User();
    }

    public List<User> getUsersByModerRole() {
        String sql = "select * from users " +
                "where role_id = " +
                "(select id from role " +
                "where type = 'MODER')";
        return jdbc.query(sql, mapper);
    }

    public List<User> getUsersByAdminRole() {
        String sql = "select * from users " +
                "where role_id = " +
                "(select id from role " +
                "where type = 'ADMIN')";
        return jdbc.query(sql, mapper);
    }


    public List<User> getUsersByUserRole() {
        String sql = "select * from users " +
                "where role_id = " +
                "(select id from role " +
                "where type = 'USER')";
        return jdbc.query(sql, mapper);
    }

    public void create(User user) {
        jdbc.update("call create_user(?,?,?)", user.getLogin(), user.getPassword(), user.getEmail());
    }

    public void delete(String login) {
        jdbc.update("call delete_user(?)", login);
    }


}
