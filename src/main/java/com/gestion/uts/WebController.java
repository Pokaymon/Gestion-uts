package com.gestion.uts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/estudiante")
    public String estudiante() {
        return "estudiante";
    }

    @GetMapping("/director")
    public String director() {
        return "director";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/evaluador")
    public String evaluador() {
        return "evaluador";
    }

    @GetMapping("/coordinacion")
    public String coordinacion() {
        return "coordinacion";
    }
}
