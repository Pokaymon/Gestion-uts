package com.gestion.uts.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class LogoutController {

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        // Crear una cookie "token" con valor vacío y expiración inmediata
        Cookie cookie = new Cookie("token", "");
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0); // Hace que la cookie se elimine inmediatamente
        response.addCookie(cookie);

        return ResponseEntity.ok("Sesión cerrada exitosamente");
    }
}

