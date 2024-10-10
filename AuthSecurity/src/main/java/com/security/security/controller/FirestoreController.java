package com.security.security.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.security.security.dto.LoginRequest;
import com.security.security.entity.User;
import com.security.security.repository.UserRepository;
import com.security.security.service.FirebaseUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firestore")
public class FirestoreController {

    private final FirebaseUserService firebaseUserService;
    private final UserRepository userRepository;

    public FirestoreController(FirebaseUserService firebaseUserService, UserRepository userRepository) {
        this.firebaseUserService = firebaseUserService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequest request) {
        try {
            UserRecord firebaseUser = firebaseUserService.createUser(request.getEmail(), request.getPassword());
            User user = new User();
            user.getEmail();
            // Set other properties
            userRepository.save(user);
            return "User registered successfully!";
        } catch (Exception e) {

            e.printStackTrace();
            return "Failed to register user.";
        }
    }

    static class RegistrationRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
            try {
                // Attempt to retrieve the user by email
                UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(loginRequest.getUsername());

                // After successful retrieval, generate a custom token for the user
                String customToken = FirebaseAuth.getInstance().createCustomToken(userRecord.getUid());

                // Return the custom token to be used by the client for Firebase Auth
                return ResponseEntity.ok().body(customToken);
            } catch (FirebaseAuthException e) {
                // Handle exceptions such as user not found or token generation failure
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
            }
        }
    }


}
