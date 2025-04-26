package com.gestion.uts;

import com.gestion.uts.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private Claims getClaimsFromCookies(HttpServletRequest request) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("token".equals(cookie.getName())) {
                    try {
                        return JwtUtil.getClaims(cookie.getValue());
                    } catch (Exception e) {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/estudiante")
    public String estudiante(HttpServletRequest request, Model model) {
        Claims claims = getClaimsFromCookies(request);
        if (claims == null) return "redirect:/";

        model.addAttribute("nombre", claims.getSubject());
        model.addAttribute("rol", claims.get("rol"));
        return "estudiante";
    }

    @GetMapping("/director")
    public String director(HttpServletRequest request, Model model) {
        Claims claims = getClaimsFromCookies(request);
        if (claims == null) return "redirect:/";

        model.addAttribute("nombre", claims.getSubject());
        model.addAttribute("rol", claims.get("rol"));
        return "director";
    }

    @GetMapping("/admin")
    public String admin(HttpServletRequest request, Model model) {
        Claims claims = getClaimsFromCookies(request);
        if (claims == null) return "redirect:/";

        model.addAttribute("nombre", claims.getSubject());
        model.addAttribute("rol", claims.get("rol"));
        return "admin";
    }

    @GetMapping("/evaluador")
    public String evaluador(HttpServletRequest request, Model model) {
        Claims claims = getClaimsFromCookies(request);
        if (claims == null) return "redirect:/";

        model.addAttribute("nombre", claims.getSubject());
        model.addAttribute("rol", claims.get("rol"));
        return "evaluador";
    }

    @GetMapping("/coordinacion")
    public String coordinacion(HttpServletRequest request, Model model) {
        Claims claims = getClaimsFromCookies(request);
        if (claims == null) return "redirect:/";

        model.addAttribute("nombre", claims.getSubject());
        model.addAttribute("rol", claims.get("rol"));
        return "coordinacion";
    }
}
