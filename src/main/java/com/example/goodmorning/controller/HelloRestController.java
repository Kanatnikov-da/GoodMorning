package com.example.goodmorning.controller;

import com.example.goodmorning.domain.GoodMorningResponse;
import com.example.goodmorning.domain.api.NotesRequestDto;
import com.example.goodmorning.domain.entiity.NoteEntity;
import com.example.goodmorning.repository.NotesRepo;
import com.example.goodmorning.service.NewsService;
import com.example.goodmorning.service.NoteService;
import com.example.goodmorning.service.WeatherForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequiredArgsConstructor
public class HelloRestController {

    private final NewsService newsService;
    private final WeatherForecastService weatherForecastService;
    private final NoteService noteService;

    private final NotesRepo notesRepo;

    @GetMapping(value = "/helloNews", produces = MediaType.APPLICATION_JSON_VALUE)
    public GoodMorningResponse helloNews() {
        //todo: логировать все входящие параметры
        //todo: логировать результат(не всегда и не весь)
        return new GoodMorningResponse(newsService.getTodayNews(), weatherForecastService.getDailyTemp(), noteService.getNotes());
    }

    @PostMapping(value = "/addNotes",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addNotes(@RequestBody NotesRequestDto requestDto){
        NoteEntity notes = new NoteEntity(requestDto.getNotes(), requestDto.getDate());
        notesRepo.save(notes);
    }


}