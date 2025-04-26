package com.gestion.uts.controller;

import com.gestion.uts.model.User;
import com.gestion.uts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{cedula}")
    public Optional<User> getUserByCedula(@PathVariable String cedula) {
        return userService.getUserByCedula(cedula);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{cedula}")
    public User updateUser(@PathVariable String cedula, @RequestBody User user) {
        return userService.updateUser(cedula, user);
    }

    @DeleteMapping("/{cedula}")
    public void deleteUser(@PathVariable String cedula) {
        userService.deleteUser(cedula);
    }
}
