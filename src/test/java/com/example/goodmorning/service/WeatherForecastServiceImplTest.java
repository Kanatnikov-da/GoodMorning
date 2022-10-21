package com.example.goodmorning.service;

import com.example.goodmorning.domain.WeatherInfo;
import com.example.goodmorning.domain.weatherForecastApi.response.MainWeather;
import com.example.goodmorning.domain.weatherForecastApi.response.WeatherResponse;
import com.example.goodmorning.service.client.weatherForecast.WeatherForecastClient;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = WeatherForecastServiceImpl.class)
class WeatherForecastServiceImplTest {
    @Autowired
    private WeatherForecastService weatherForecastService;
    @MockBean
    private WeatherForecastClient weatherForecastClient;

    @Test
    void getWeather(){
        EasyRandomParameters easyRandomParameters = new EasyRandomParameters();
        easyRandomParameters.randomize(field -> field.getName().equals(MainWeather.Fields.temp_max), () -> BigDecimal.valueOf(283.19));
        EasyRandom easyRandom = new EasyRandom(easyRandomParameters);

        WeatherResponse weatherMain = easyRandom.nextObject(WeatherResponse.class);
        Mockito.doReturn(weatherMain).when(weatherForecastClient).getWeather();

        WeatherInfo actual = weatherForecastService.getDailyTemp();
        assertEquals(BigDecimal.valueOf(10.03d), actual.getMaxTemp());
    }
}
