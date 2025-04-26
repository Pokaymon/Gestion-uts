package com.gestion.uts.config;

import com.gestion.uts.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

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
        } catch (Exception e) {
            response.sendRedirect("/");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
