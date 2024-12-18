package com.BookStore.App.Service.Impl;

import com.BookStore.App.Model.User;
import com.BookStore.App.Repository.UserRepository;
import com.BookStore.App.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    public User register(User user) {
    	return userRepository.save(user);
    }

    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
    

    public List<User> getUsers() {
    	return userRepository.findAll();
	}

	public User updateUser(User user) {
    	User existingUser = userRepository.findByEmail(user.getEmail());
    
    	if(existingUser != null) {
//    		existingUser.setFirstName(user.getFirstName());
//    		existingUser.setLastName(user.getLastName());
    		existingUser.setPassword(user.getPassword());
    		return userRepository.save(existingUser);    		
    	}
    	else 
    		return null;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

	 

}
