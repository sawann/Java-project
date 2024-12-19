package com.springtest.services;

import com.springtest.models.User;
import com.springtest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository repository) {

        userRepository = repository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id) throws Exception {
        Optional<User> localUser = userRepository.findById(id);
        if (localUser.isEmpty()) {
            throw new Exception("User not found");
        }
        userRepository.deleteById(id);
    }
}