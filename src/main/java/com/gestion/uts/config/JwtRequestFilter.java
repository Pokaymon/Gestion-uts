package com.gestion.uts.config;

import com.gestion.uts.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Permitir el paso sin validación JWT en rutas públicas
        String path = request.getRequestURI();
        if (path.equals("/") || path.startsWith("/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        if (token == null) {
            response.sendRedirect("/");
            return;
        }

        try {
            Claims claims = JwtUtil.getClaims(token);
            request.setAttribute("claims", claims);

            String cedula = claims.getSubject(); // Identificador del usuario
            String rol = (String) claims.get("rol"); // Rol guardado en el token

            // Crear Authentication con el rol
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            cedula,
                            null,
                            Collections.singletonList(new SimpleGrantedAuthority(rol.toLowerCase()))
                    );

            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (Exception e) {
            response.sendRedirect("/");
            return;
        }

        filterChain.doFilter(request, response);
    }
}

