package com.example.goodmorning.domain.weatherForecastApi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import java.math.BigDecimal;

@Data
@FieldNameConstants
public class MainWeather {
    @JsonProperty("temp")
    public BigDecimal temp;
    @JsonProperty("feels_like")
    public double feels_like;
    @JsonProperty("temp_min")
    public BigDecimal temp_min;
    @JsonProperty("temp_max")
    public BigDecimal temp_max;
    @JsonProperty("pressure")
    public int pressure;
    @JsonProperty("humidity")
    public int humidity;
    @JsonProperty("sea_level")
    public int sea_level;
    @JsonProperty("grnd_level")
    public int grnd_level;
}
