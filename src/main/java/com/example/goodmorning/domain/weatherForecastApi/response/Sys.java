package com.example.goodmorning.domain.weatherForecastApi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Sys {
    @JsonProperty("type")
    public int type;
    @JsonProperty("id")
    public int id;
    @JsonProperty("country")
    public String country;
    @JsonProperty("sunrise")
    public int sunrise;
    @JsonProperty("sunset")
    public int sunset;
}
