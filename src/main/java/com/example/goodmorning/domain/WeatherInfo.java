package com.example.goodmorning.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfo {
    @JsonProperty("minTemp")
    private BigDecimal minTemp;
    @JsonProperty("maxTemp")
    private BigDecimal maxTemp;
    @JsonProperty("currentTemp")
    private BigDecimal currentTemp;
}
