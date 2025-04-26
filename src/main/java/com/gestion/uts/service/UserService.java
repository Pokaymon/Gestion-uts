package com.gestion.uts.service;

import com.gestion.uts.model.User;
import com.gestion.uts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByCedula(String cedula) {
        return userRepository.findByCedula(cedula);
    }

    public User createUser(User user) {
        if (userRepository.existsByCedula(user.getCedula())) {
            throw new RuntimeException("La cédula ya está registrada.");
        }
        return userRepository.save(user);
    }

    public User updateUser(String cedula, User updatedUser) {
        Optional<User> existing = userRepository.findByCedula(cedula);
        if (existing.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado con esa cédula.");
        }
        User user = existing.get();
        user.setNombre(updatedUser.getNombre());
        user.setApellido(updatedUser.getApellido());
        user.setPassword(updatedUser.getPassword());
        user.setRol(updatedUser.getRol());
        return userRepository.save(user);
    }

    public void deleteUser(String cedula) {
        Optional<User> existing = userRepository.findByCedula(cedula);
        existing.ifPresent(user -> userRepository.deleteById(user.getId()));
    }
}
