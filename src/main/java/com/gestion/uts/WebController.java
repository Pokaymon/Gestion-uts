package com.gestion.uts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/")
    public String home() {
        return "Bienvenido";
    }

    @GetMapping("/estudiante")
    public String estudiante() {
        return "Hola Estudiante";
    }

    @GetMapping("/director")
    public String director() {
        return "Hola Director";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hola Admin";
    }

    @GetMapping("/evaluador")
    public String evaluador() {
        return "Hola Evaluador";
    }

    @GetMapping("/coordinacion")
    public String coordinacion() {
        return "Hola Coordinacion";
    }
}
