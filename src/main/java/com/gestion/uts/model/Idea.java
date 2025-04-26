package com.gestion.uts.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "ideas")
public class Idea {

    @Id
    private String id;
    private String titulo;
    private String descripcion;
    private String tecnologias;
    private LocalDate fechaPropuesta;
    private String observaciones;

    public Idea() {
    }

    public Idea(String titulo, String descripcion, String tecnologias, LocalDate fechaPropuesta, String observaciones) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tecnologias = tecnologias;
        this.fechaPropuesta = fechaPropuesta;
        this.observaciones = observaciones;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }

    public LocalDate getFechaPropuesta() {
        return fechaPropuesta;
    }

    public void setFechaPropuesta(LocalDate fechaPropuesta) {
        this.fechaPropuesta = fechaPropuesta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
