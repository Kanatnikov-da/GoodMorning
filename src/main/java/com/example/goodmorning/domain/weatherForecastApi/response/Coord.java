package com.example.goodmorning.domain.weatherForecastApi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Coord {
    @JsonProperty("lon")
    public double lon;
    @JsonProperty("lat")
    public double lat;
}
