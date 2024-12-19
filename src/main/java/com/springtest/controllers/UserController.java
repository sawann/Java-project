package com.springtest.controllers;

import com.springtest.models.User;
import com.springtest.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return service.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserData(@PathVariable int id, @RequestBody User user) {
        Optional<User> localUser = service.findById(id).map( item -> {
            item.setFirst_name(user.getFirst_name());
            item.setLast_name(user.getLast_name());
            item.setAge(user.getAge());
            return service.save(item);
        });
        if (localUser.isEmpty()) {
            return ResponseEntity.internalServerError().body("User does not exist");
        }
        return ResponseEntity.ok("Successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok("User successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error or user already not exist");
        }
    }
}