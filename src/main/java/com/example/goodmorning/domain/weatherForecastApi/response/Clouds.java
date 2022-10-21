package com.example.goodmorning.domain.weatherForecastApi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Clouds {
    @JsonProperty("all")
    public int all;
}
