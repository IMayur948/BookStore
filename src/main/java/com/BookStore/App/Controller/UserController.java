package com.BookStore.App.Controller;

import com.BookStore.App.Controller.POJO.UserRequest;
import com.BookStore.App.Model.User;
import com.BookStore.App.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/bookStore/api/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    // UserBean To User
    private User convertToUser(UserRequest userRequest) {
    	User user = new User();
    	user.setUsername(userRequest.getUsername());
    	user.setEmail(userRequest.getEmail());
    	user.setRole(userRequest.getRole());
    	user.setPassword(userRequest.getPassword());
    	return user;
    	
    }
    
    // User To UserBean
    private UserRequest convertToUserBean(User user){
        return new UserRequest(user.getUsername(),user.getEmail(),user.getPassword(),user.getRole());
    }
    
    // UserList to UserBeanList
    private List<UserRequest> convertToUserBeanList(List<User> users){
        List<UserRequest> userRequests = new ArrayList<>();
        for(User user : users){
            userRequests.add(convertToUserBean(user));
        }
        return userRequests;
    }

    // Validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

 // Get all users
    @GetMapping("/getAll")
    public ResponseEntity<List<UserRequest>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserRequest> userRequests = convertToUserBeanList(users);
        return new ResponseEntity<>(userRequests, HttpStatus.OK);
    }

    // Register user
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserRequest userRequest) {
    	User user = convertToUser(userRequest);
        userService.register(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    // User login
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestParam String email, @Valid @RequestParam String password) {
        boolean isAuthenticated = userService.login(email, password);
        if (isAuthenticated) {
            return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
    }

//    // Update user
//    @PutMapping("/update")
//    public ResponseEntity<String> updateUser(@Valid @RequestBody User user) {
//        userService.updateUser(user);
//        return new ResponseEntity<>("User information updated successfully", HttpStatus.OK);
//    }
//
//    // Delete user
//    @DeleteMapping("/delete/{username}")
//    public ResponseEntity<String> deleteUser(@Valid @PathVariable String username) {
//        userService.deleteUser(username);
//        return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
//    }
}