package com.BookStore.App.Service;

import com.BookStore.App.Model.User;

import java.util.List;

public interface UserService {
    void register(User user);
    boolean login(String username, String password);

    List<User> getAllUsers();

    //    User updateUser(User user);
    //    void deleteUser(String username);

}
