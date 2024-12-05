package com.BookStore.App.Service;

import com.BookStore.App.Model.User;

public interface UserService {
    void register(User user);
    boolean login(String username, String password);

}
