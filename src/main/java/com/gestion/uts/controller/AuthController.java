package com.gestion.uts.controller;

import com.gestion.uts.model.LoginRequest;
import com.gestion.uts.model.LoginResponse;
import com.gestion.uts.model.User;
import com.gestion.uts.service.UserService;
import com.gestion.uts.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest request) {
        User user = userService.getUserByCedula(request.getCedula()).orElse(null);
        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return "Credenciales inválidas";
        }

        String token = JwtUtil.generateToken(user.getCedula(), user.getRol());

        return new LoginResponse("Bearer" + token, user.getRol(), user.getNombre());
    }
}

