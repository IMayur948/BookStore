package com.BookStore.App.Service.Impl;

import com.BookStore.App.Model.User;
import com.BookStore.App.Repository.Impl.UserRepositoryImpl;
import com.BookStore.App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositoryImpl userRepository;


    public void register(User user) {
        userRepository.save(user);
    }

    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }
    public void deleteUser(String username) {
        userRepository.delete(username);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
