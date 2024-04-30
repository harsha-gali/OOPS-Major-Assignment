package com.example.twitter.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        LoginResult result = userService.loginUser(email, password);

        if (result == LoginResult.LOGIN_SUCCESSFUL) {
            return ResponseEntity.ok("Login Successful");
        } else if (result == LoginResult.USERNAME_PASSWORD_INCORRECT) {
            UserNotFoundResponse response = new UserNotFoundResponse();
            response.setError("Username/Password Incorrect");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            UserNotFoundResponse response = new UserNotFoundResponse();
            response.setError("User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<Object> signupUser(@RequestBody SignupRequest signupRequest) {
        String email = signupRequest.getEmail();
        String name = signupRequest.getName();
        String password = signupRequest.getPassword();

        SignupResponse response = userService.signupUser(email, name, password);
        if (response == SignupResponse.ACCOUNT_CREATION_SUCCESSFUL) {
            return ResponseEntity.ok("Account Creation Successful");
        } else
        {
            UserNotFoundResponse Response = new UserNotFoundResponse();
            Response.setError("Forbidden, Account already exists");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Response);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<Object> getUserDetails(@RequestParam int userID) {
        User user = userService.getUserByID(userID);

        if (user != null) {
            UserDetails userDetails = new UserDetails(user.getName(), user.getUserID(), user.getEmail());
            return ResponseEntity.ok(userDetails);
        } else {
            UserNotFoundResponse response = new UserNotFoundResponse();
            response.setError("User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        List<UsersDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}

