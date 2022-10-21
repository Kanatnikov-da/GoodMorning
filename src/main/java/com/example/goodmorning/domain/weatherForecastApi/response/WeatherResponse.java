package com.example.goodmorning.domain.weatherForecastApi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {
    @JsonProperty("coord")
    public Coord coord;
    @JsonProperty("weather")
    public List<WeatherDescription> weather;
    @JsonProperty("base")
    public String base;
    @JsonProperty("main")
    public MainWeather main;
    @JsonProperty("visibility")
    public int visibility;
    @JsonProperty("wind")
    public Wind wind;
    @JsonProperty("clouds")
    public Clouds clouds;
    @JsonProperty("dt")
    public int dt;
    @JsonProperty("sys")
    public Sys sys;
    @JsonProperty("timezone")
    public int timezone;
    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("cod")
    public int cod;
}
