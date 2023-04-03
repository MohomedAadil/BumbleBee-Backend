package com.example.backendb.controller;

import com.example.backendb.entity.User;
import com.example.backendb.repository.UserRepository;
import com.example.backendb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;

@RestController
//@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "login";
//    }

    @PostMapping("/addUsers")
    public User addUsers(@RequestBody User user){
        return userService.addUser(user);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        } else {
            return ResponseEntity.ok("Login successful");
        }
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        existingUser.setUsername(user.getUsername());
//        existingUser.setDOB(user.getDOB());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhone(user.getPhone());
        userRepository.save(existingUser);
        return ResponseEntity.ok(existingUser);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }
}
