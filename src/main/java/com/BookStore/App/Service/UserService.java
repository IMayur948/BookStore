package com.BookStore.App.Service;

import com.BookStore.App.Model.User;

import java.util.List;

public interface UserService {
    User register(User user);
    boolean login(String email, String password);
    User updateUser(User user);
    void deleteUser(int id);
    List<User> getUsers();

//    User updateUser(User user);
//    void deleteUser(String email);

}
