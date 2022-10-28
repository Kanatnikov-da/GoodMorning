package com.example.goodmorning.controller;

import com.example.goodmorning.domain.GoodMorningResponse;
import com.example.goodmorning.domain.NoteInfo;
import com.example.goodmorning.domain.newsApi.response.NewsResponse;
import com.example.goodmorning.domain.weatherForecastApi.response.MainWeather;
import com.example.goodmorning.domain.weatherForecastApi.response.WeatherResponse;
import com.example.goodmorning.service.NoteService;
import com.example.goodmorning.service.client.news.NewsClient;
import com.example.goodmorning.service.client.weatherForecast.WeatherForecastClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
class HelloRestControllerTest {
    @Autowired private MockMvc mvc;

    @MockBean
    private NewsClient newsClient;
    @MockBean
    private WeatherForecastClient weatherForecastClient;
    @MockBean
    private NoteService noteService;

    @Test
    void helloRest() throws Exception {
        EasyRandomParameters easyRandomParameters = new EasyRandomParameters();
        EasyRandom easyRandom = new EasyRandom();

        NewsResponse newsResponse = easyRandom.nextObject(NewsResponse.class);
        Mockito.doReturn(newsResponse).when(newsClient).getNews();

        easyRandomParameters.randomize(field -> field.getName().equals(MainWeather.Fields.temp_max), () -> BigDecimal.valueOf(283.19));
        WeatherResponse weatherMain = easyRandom.nextObject(WeatherResponse.class);
        Mockito.doReturn(weatherMain).when(weatherForecastClient).getWeather();

        List<NoteInfo> notes = new ArrayList<>();
        notes.add(new NoteInfo(12L, "afasfsfsf", LocalDate.now()));
        notes.add(new NoteInfo(13L, "hasdfas", LocalDate.now()));
        Mockito.doReturn(notes).when(noteService).getNotes();

        MvcResult result =  mvc.perform(get("/helloNews"))
                .andExpect(status().isOk()).andReturn();
        GoodMorningResponse response = new ObjectMapper().registerModule(new JavaTimeModule()).readValue(result.getResponse().getContentAsString(), GoodMorningResponse.class);

        assertEquals(response.getNotes(), notes);
        newsResponse.getArticles().forEach(article ->
                assertTrue(newsResponse.getArticles().contains(article)));
    }
}

