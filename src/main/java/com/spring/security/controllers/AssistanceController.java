package com.spring.security.controllers;
import com.spring.security.advice.NotFoundException;
import com.spring.security.dto.AssistanceDto;
import com.spring.security.service.AssistanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Endpoints de Asistencia", description = "CRUD de Asistencia")
@RequestMapping("/assistance")
@RestController
public class AssistanceController {
    @Autowired
    private AssistanceService service;

//    @Autowired
//    private InterpretationService interpretationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AssistanceDto> findAll() {
        return service.findAll();
    }

//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public AssistanceDto getEntityById(@PathVariable Long id) throws NotFoundException {
//        return service.findById(id);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssistanceDto save(@Valid @RequestBody AssistanceDto data) {
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

//    @PutMapping("{artistId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void update(@PathVariable long artistId, @Valid @RequestBody AssistanceDto data) throws NotFoundException {
//        service.update(artistId, data);
//    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) throws NotFoundException {
        service.deleteById(id);
    }
}
