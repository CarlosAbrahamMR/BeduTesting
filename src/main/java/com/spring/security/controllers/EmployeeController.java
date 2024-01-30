package com.spring.security.controllers;
import com.spring.security.advice.NotFoundException;
import com.spring.security.dto.EmployeeDto;
import com.spring.security.model.Employee;
import com.spring.security.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Endpoints de Empleados", description = "CRUD de Empleados")
@RequestMapping("/empleados")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

//    @Autowired
//    private InterpretationService interpretationService;

    @GetMapping
    @JsonIgnore
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> findAll() throws NotFoundException {
        return service.findAll();
    }

    @JsonIgnore
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/turno/{turnoId}")
    public List<Employee> obtenerEmpleadosPorTurno(@PathVariable Long TurnoId) {
        return service.findByShift(TurnoId);

    }
//aa
    @JsonIgnore
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/departamento/{departamento}")
    public List<Employee> obtenerEmpleadosPorDepartamento(@PathVariable String departamento) {
        return service.findByDepartment(departamento);

    }


    @JsonIgnore
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/pendientes/")
    public List<Employee> getEmployeesByContracted() {
        return service.findByContractedSignedFalse();

    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto getEntityById(@PathVariable Long id) throws NotFoundException{
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto save(@Valid @RequestBody EmployeeDto data) {
        return service.save(data);
    }

//    @Operation(summary = "Asocia una canción a un artista")
//    @PostMapping("{artistId}/songs")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void addSong(@PathVariable long artistId, @RequestBody AddSongDTO data) {
//        interpretationService.addSong(artistId, data.getSongId());
//    }

//    @GetMapping("{artistId}/songs")
//    @ResponseStatus(HttpStatus.OK)
//    public List<SongDTO> findSongsByArtist(@PathVariable long artistId) {
//        return interpretationService.findSongsByArtist(artistId);
   // }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public List<EmployeeDto> saveAll( @RequestBody List<EmployeeDto> dataList) {
        return service.saveAll(dataList);
    }

    @PutMapping("{artistId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long artistId, @Valid @RequestBody EmployeeDto data) throws NotFoundException {
        service.update(artistId, data);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) throws NotFoundException {
        service.deleteById(id);
    }

    @GetMapping("/ingresar")
    public String index() {
        return "index";
    }
}
