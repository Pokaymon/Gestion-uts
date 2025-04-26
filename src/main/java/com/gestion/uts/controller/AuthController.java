package com.gestion.uts.controller;

import com.gestion.uts.model.LoginRequest;
import com.gestion.uts.model.LoginResponse;
import com.gestion.uts.model.User;
import com.gestion.uts.service.UserService;
import com.gestion.uts.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpServletResponse response) {
        User user = userService.getUserByCedula(request.getCedula()).orElse(null);
            if (user == null || !user.getPassword().equals(request.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
            }

        String token = JwtUtil.generateToken(user.getCedula(), user.getRol());

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600); // 1 hora
        response.addCookie(cookie);

        return ResponseEntity.ok(new LoginResponse("Bearer " + token, user.getRol(), user.getNombre()));
    }
}

