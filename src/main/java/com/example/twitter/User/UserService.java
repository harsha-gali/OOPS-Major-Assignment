package com.example.twitter.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResult loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return LoginResult.USER_NOT_FOUND;
        } else if (!user.getPassword().equals(password)) {
            return LoginResult.USERNAME_PASSWORD_INCORRECT;
        } else {
            return LoginResult.LOGIN_SUCCESSFUL;
        }
    }

    public SignupResponse signupUser(String email, String name, String password) {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            return SignupResponse.ACCOUNT_ALREADY_EXISTS;
        } else {
            User newUser = new User(name, email, password);
            userRepository.save(newUser);
            return SignupResponse.ACCOUNT_CREATION_SUCCESSFUL;
        }
    }

    public User getUserByID(int userID) {
        Optional<User> userOptional = userRepository.findById(userID);
        return userOptional.orElse(null);
    }

    public List<UsersDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UsersDTO convertToDTO(User user) {
        return new UsersDTO( user.getName(), user.getUserID(),user.getEmail());
    }
}

