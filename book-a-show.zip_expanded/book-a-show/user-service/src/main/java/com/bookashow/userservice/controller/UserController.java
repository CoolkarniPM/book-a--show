// user-service/src/main/java/com/bookashow/user/controller/UserController.java
package com.bookashow.userservice.controller;

import com.bookashow.userservice.model.User;
import com.bookashow.userservice.service.UserService;
import com.bookashow.userservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user){
        if(userService.findByUsername(user.getUsername()).isPresent()){
            return ResponseEntity.badRequest().body("Username is already taken!");
        }
        if(userService.findByUsername(user.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("Email is already in use!");
        }
        // Additional validations can be added
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User user){
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            final String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(token);
        } catch (BadCredentialsException e){
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    // Additional endpoints as needed
}
