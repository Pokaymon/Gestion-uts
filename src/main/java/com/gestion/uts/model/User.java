package com.gestion.uts.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    private String cedula;

    private String password;
    private String nombre;
    private String apellido;
    private String rol;

    public User() {}

    public User(String cedula, String password, String nombre, String apellido, String rol) {
        this.cedula = cedula;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;}

    public String getId() {
        return id;}

    public String getCedula() {
        return cedula;}
    public void setCedula(String cedula) {
        this.cedula = cedula;}

    public String getPassword() {
        return password;}
    public void setPassword(String password) {
        this.password = password;}

    public String getNombre() {
        return nombre;}
    public void setNombre(String nombre) {
        this.nombre = nombre;}

    public String getApellido() {
        return apellido;}
    public void setApellido(String apellido) {
        this.apellido = apellido;}

    public String getRol() {
        return rol;}
    public void setRol(String rol) {
        this.rol = rol;}
}
