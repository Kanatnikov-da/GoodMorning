package com.example.goodmorning.service.client.weatherForecast;

import com.example.goodmorning.domain.weatherForecastApi.response.WeatherResponse;
import com.example.goodmorning.properties.WeatherApiProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherForecastClientImpl implements WeatherForecastClient {

    private final WeatherApiProperties weatherApiProperties;

    @Override
    public WeatherResponse getWeather() {
        RestTemplate restTemplate = new RestTemplate();

        URL url = new HttpUrl.Builder()
                .scheme("https")
                .host(weatherApiProperties.getBaseHost())
                .addPathSegments("data/2.5/weather")
                .addQueryParameter("lat", "55.75")
                .addQueryParameter("lon", "37.61")
                .addQueryParameter("appid", weatherApiProperties.getApiKey())
                .build().url();


        //todo: logBack логи добваить
        WeatherResponse weatherResponse = restTemplate.getForObject(url.toString(), WeatherResponse.class);
        log.info("Received weatherResponse '{}'", weatherResponse);
        return weatherResponse;
    }
}
