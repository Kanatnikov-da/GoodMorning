package com.example.goodmorning.domain.weatherForecastApi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Wind {
    @JsonProperty("speed")
    public double speed;
    @JsonProperty("deg")
    public int deg;
    @JsonProperty("gust")
    public double gust;
}
