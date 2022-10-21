package com.example.goodmorning.service;

import com.example.goodmorning.domain.WeatherInfo;
import com.example.goodmorning.domain.weatherForecastApi.response.MainWeather;
import com.example.goodmorning.service.client.weatherForecast.WeatherForecastClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import static com.example.goodmorning.utils.Utils.getCelsius;

@Service
@RequiredArgsConstructor
public class WeatherForecastServiceImpl implements WeatherForecastService{

    private final WeatherForecastClient weatherForecastClient;
    //TODO: tests
    //TODO: ПОПРОБОВАТЬ MAPSTRUCT
    @Override
    public WeatherInfo getDailyTemp() {
       MainWeather mainWeather = weatherForecastClient.getWeather().getMain();
       return new WeatherInfo(getCelsius(mainWeather.getTemp_min()), getCelsius(mainWeather.getTemp_max()),
               getCelsius(mainWeather.getTemp()));
    }

}
