package com.example.goodmorning.controller;

import com.example.goodmorning.domain.GoodMorningResponse;
import com.example.goodmorning.service.NewsService;
import com.example.goodmorning.service.NoteService;
import com.example.goodmorning.service.WeatherForecastService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping(value = "/helloNews", produces = MediaType.APPLICATION_JSON_VALUE)
    public GoodMorningResponse helloNews() {
        //todo: логировать результат(не всегда и не весь)
        return new GoodMorningResponse(newsService.getTodayNews(), weatherForecastService.getDailyTemp(), noteService.getNotes());
    }

}