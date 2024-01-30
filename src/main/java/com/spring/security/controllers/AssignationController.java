package com.spring.security.controllers;

import com.spring.security.service.AssignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/asignacion")
public class AssignationController {
    @Autowired
    private AssignationService service;

    @PostMapping("/{empleadoId}/{articuloId}")
    public ResponseEntity<String> asignarArticuloAEmpleado(@PathVariable Long empleadoId, @PathVariable Long articuloId) {
        try {
            service.asignarArticuloAEmpleado(empleadoId, articuloId);
            return new ResponseEntity<>("Artículo asignado correctamente.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>( "Error interno del servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{empleadoId}/{articuloId}")
    public ResponseEntity<String> eliminarAsignacion(@PathVariable Long empleadoId, @PathVariable Long articuloId) {
        try {
            service.eliminarAsignacion(empleadoId, articuloId);
            return new ResponseEntity<>("Asignación eliminada correctamente.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
