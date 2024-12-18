package com.BookStore.App.Repository;

import java.util.List;

import com.BookStore.App.Model.User;
 
public interface UserRepository {
    void save(User user);
    User findByUsername(String username);
    void update(User user);
    void delete(String username);

    User findByEmail(String email);
	List<User> findAll();
}
