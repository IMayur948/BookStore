package com.BookStore.App.Controller;

import com.BookStore.App.Controller.POJO.GetUserResponse;
import com.BookStore.App.Controller.POJO.UserRequest;
import com.BookStore.App.Controller.POJO.UserResponse;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookStore/api/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;
  
    
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
    @GetMapping
    public ResponseEntity<GetUserResponse> getAllUsers() {
        List<User> users = userService.getUsers(); 
        
        List<UserResponse> userResponseList = users.stream()
        		.map(user -> new UserResponse(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail()))
        		.collect(Collectors.toList());
        return new ResponseEntity<>(new GetUserResponse(userResponseList), HttpStatus.OK);
    }

    // Register user
    @PostMapping("/register")
    public ResponseEntity<GetUserResponse> register(@Valid @RequestBody UserRequest userRequest) {
    	User user = new User(userRequest.getFirstName(), userRequest.getLastName(),userRequest.getEmail(),userRequest.getPassword());
        User newUser = userService.register(user);
        UserResponse userResponse = new UserResponse(newUser.getId(),newUser.getFirstName(),newUser.getLastName(),newUser.getEmail());
        List<UserResponse> userResponseList = Collections.singletonList(userResponse);
        return new ResponseEntity<>(new GetUserResponse(userResponseList), HttpStatus.CREATED);
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

    // Update user
    @PutMapping("/update")
    public ResponseEntity<GetUserResponse> updateUser(@Valid @RequestBody UserRequest userRequest) {
        User user = new User(userRequest.getFirstName(),userRequest.getLastName(),userRequest.getEmail(),userRequest.getPassword());
    	User newUser = userService.updateUser(user);
    	UserResponse userResponse = new UserResponse(newUser.getId(),newUser.getFirstName(),newUser.getLastName(),newUser.getEmail());
    	List<UserResponse> userResponseList = Collections.singletonList(userResponse);
        return new ResponseEntity<>(new GetUserResponse(userResponseList), HttpStatus.OK);
    }

    // Delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@Valid @PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
    }
}