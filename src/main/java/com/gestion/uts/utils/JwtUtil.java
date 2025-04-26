package com.gestion.uts.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.security.Key;

public class JwtUtil {

    private static final String SECRET_KEY = "secret_uts_secret_uts_secret_uts_"; // mínimo 32 bytes para HS256

    private static final Key KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public static String generateToken(String cedula, String rol) {
        return Jwts.builder()
                .setSubject(cedula)
                .claim("rol", rol)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public static Claims getClaims(String token) {
    return Jwts.parserBuilder()
            .setSigningKey(KEY)
            .build()
            .parseClaimsJws(token)
            .getBody();
    }
}
