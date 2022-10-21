package com.example.goodmorning.service.client.weatherForecast;

import com.example.goodmorning.domain.weatherForecastApi.response.WeatherResponse;

public interface WeatherForecastClient {
    WeatherResponse getWeather();

}
