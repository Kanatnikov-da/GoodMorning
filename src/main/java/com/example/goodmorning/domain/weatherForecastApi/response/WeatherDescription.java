package com.example.goodmorning.domain.weatherForecastApi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherDescription {
    @JsonProperty("id")
    public int id;
    @JsonProperty("main")
    public String main;
    @JsonProperty("description")
    public String description;
    @JsonProperty("icon")
    public String icon;
}
