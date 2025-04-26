package com.gestion.uts.model;

public class LoginResponse {
    private String token;
    private String rol;
    private String nombre;

    public LoginResponse(String token, String rol, String nombre) {
        this.token = token;
        this.rol = rol;
        this.nombre = nombre;
    }

    public String getToken() {
        return token;
    }

    public String getRol() {
        return rol;
    }

    public String getNombre() {
        return nombre;
    }
}

