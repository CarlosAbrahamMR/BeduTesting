package com.spring.security.templateController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class LoginController {

    @GetMapping("/ingresar")
    public String index() {
        return "auth-login";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "/layouts/dashboard";
    }

    @GetMapping("/detalle-empleado/{id}")
    public String details() {
        return "pages/details";
    }

    @GetMapping("/empleado-nuevo")
    public String empleadoNuevo() {
        return "pages/form";
    }

    @GetMapping("/inventary")
    public String inventary() {
        return "pages/inventario";
    }

    @GetMapping("/asignaciones/{id}")
    public String asignaciones() {
        return "pages/asignaciones";
    }

    @GetMapping("/contrato/{id}")
    public String contrato() {
        return "pages/contrato";
    }

    @GetMapping("/carta/{id}")
    public String carta() {
        return "pages/carta";
    }

    @GetMapping("/pendientes")
    public String pendientes() {
        return "pages/pendientes";
    }

    @GetMapping("/empleadoRol")
    public String Rol() {
        return "pages/EmpleadoRol";
    }
}