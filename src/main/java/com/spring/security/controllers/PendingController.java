package com.spring.security.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.security.advice.NotFoundException;
import com.spring.security.dto.PendingDTO;
import com.spring.security.service.PendingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inactivos")
public class PendingController {

    @Autowired
    private PendingService service;

//    @Autowired
//    private InterpretationService interpretationService;

    @GetMapping
    @JsonIgnore
    @ResponseStatus(HttpStatus.OK)
    public List<PendingDTO> findAll() throws NotFoundException {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PendingDTO getEntityById(@PathVariable Long id) throws NotFoundException{
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PendingDTO save(@Valid @RequestBody PendingDTO data) {
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

    @PutMapping("{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long Id, @Valid @RequestBody PendingDTO data) throws NotFoundException {
        service.update(Id, data);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) throws NotFoundException {
        service.deleteById(id);
    }
}
