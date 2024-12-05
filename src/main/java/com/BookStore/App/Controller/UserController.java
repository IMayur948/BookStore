package com.BookStore.App.Controller;

import com.BookStore.App.Model.Book;
import com.BookStore.App.Model.BookBean;
import com.BookStore.App.Model.User;
import com.BookStore.App.Model.UserBean;
import com.BookStore.App.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    // User To UserBean
    private UserBean convertToUserBean(User user){
        return new UserBean(user.getUsername(),user.getEmail(),user.getRole());
    }
    // UserList to UserBeanList
    private List<UserBean> convertToUserBeanList(List<User> users){
        List<UserBean> userBeans = new ArrayList<>();
        for(User user : users){
            userBeans.add(convertToUserBean(user));
        }
        return userBeans;
    }

    @GetMapping("/getAll")
    public List<UserBean> getAllusers(){
        List<User> users = userService.getAllUsers();
        return convertToUserBeanList(users);
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.register(user);
        return "User registered";
    }
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean isAuthenticated = userService.login(email,password);
        if(isAuthenticated){
            return "User logged in";
        }
        return "Login failed";
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return "User information updated successfully";
    }

    @DeleteMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return "User deleted successfully";
    }



}
