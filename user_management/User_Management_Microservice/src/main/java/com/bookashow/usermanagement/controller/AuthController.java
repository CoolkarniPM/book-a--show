package com.bookashow.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookashow.usermanagement.entity.User;
import com.bookashow.usermanagement.payloads.AuthRequest;
import com.bookashow.usermanagement.payloads.AuthResponse;
import com.bookashow.usermanagement.payloads.ApiResponse;
import com.bookashow.usermanagement.repo.UserRepository;
import com.bookashow.usermanagement.security.JwtUtil;

@RestController
@RequestMapping("/users")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
    	
        try {
            // Authenticate the user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            // Fetch user details
            UserDetails userDetails = userRepository.findByUsername(authRequest.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Generate JWT token
            String token = jwtUtil.generateToken(userDetails);

            // Return successful login response
            return ResponseEntity.ok(new ApiResponse(true, "Login successful", new AuthResponse(token)));
        } catch (Exception e) {
            // Handle login failure
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Invalid username or password"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Username is already taken."));
        }

        user.setRoles("NORMAL");
        // Encode the password and save the user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        // Return successful registration response
        return ResponseEntity.ok(new ApiResponse(true, "Registration successful", user));
    }
}
