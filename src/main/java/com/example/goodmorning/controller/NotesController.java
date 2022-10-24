package com.example.goodmorning.controller;

import com.example.goodmorning.domain.NoteInfo;
import com.example.goodmorning.domain.api.NotesRequestDto;
import com.example.goodmorning.domain.entiity.NoteEntity;
import com.example.goodmorning.repository.NotesRepo;
import com.example.goodmorning.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequiredArgsConstructor
public class NotesController {
    private final NoteService noteService;

    private final NotesRepo notesRepo;

    @PostMapping(value = "/note",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addNote(@RequestBody NotesRequestDto requestDto){
        NoteEntity notes = new NoteEntity(requestDto.getNotes(), requestDto.getDate());
        notesRepo.save(notes);
    }

    @GetMapping(value = "/note/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteInfo getNote(@PathVariable(name="id") Long id) {
        return noteService.getNote(id);
    }

    @DeleteMapping(value = "/note/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(@PathVariable(name="id") Long id) {
        notesRepo.deleteById(id);
    }
}
