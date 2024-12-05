package com.BookStore.App.Repository.Impl;

import com.BookStore.App.Model.User;
import com.BookStore.App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = (rs, rowNum) -> new User(
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("role")
    );

    public void save(User user) {
        String sql = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getRole());
    }

    public User findByUsername(String username) {
        String sql = "SELECT username, email, password, role FROM users WHERE username = ?";
        User user = jdbcTemplate.queryForObject(sql, userRowMapper, username);
        return user;

    }
    public User findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        User user = jdbcTemplate.queryForObject(sql, userRowMapper, email);
        return user;

    }

    public void update(User user) {
        String sql = "UPDATE users SET email = ?, password= ? , role = ? WHERE username = ?";
        jdbcTemplate.update(sql, user.getEmail(), user.getPassword(), user.getRole(), user.getUsername());
    }

    public void delete(String username) {
        String sql = "DELETE FROM users WHERE username = ?";
        jdbcTemplate.update(sql, username);
    }
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        List<User> users = jdbcTemplate.query(sql, userRowMapper);
        return users;
    }
}
