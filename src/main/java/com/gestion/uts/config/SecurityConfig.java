package com.gestion.uts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**", "/login", "/").permitAll()
                .requestMatchers("/estudiante/**").hasAuthority("estudiante")
                .requestMatchers("/coordinacion/**").hasAuthority("coordinacion")
                .requestMatchers("/director/**").hasAuthority("director")
                .requestMatchers("/evaluador/**").hasAuthority("evaluador")
                .anyRequest().authenticated()
            )
            .addFilterBefore(new JwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

