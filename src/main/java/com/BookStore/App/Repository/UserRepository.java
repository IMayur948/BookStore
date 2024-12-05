package com.BookStore.App.Repository;

import com.BookStore.App.Model.User;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    User findByUsername(String username);
    void update(User user);
    void delete(String username);

    User findByEmail(String email);
}
