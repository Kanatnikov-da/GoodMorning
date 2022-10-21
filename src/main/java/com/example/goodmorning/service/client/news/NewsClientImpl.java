package com.example.goodmorning.service.client.news;

import com.example.goodmorning.domain.newsApi.response.NewsResponse;
import com.example.goodmorning.properties.NewsApiProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URL;

import static org.apache.tomcat.util.http.FastHttpDateFormat.getCurrentDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewsClientImpl implements NewsClient {

    private final NewsApiProperties newsApiProperties;

    @Override
    public NewsResponse getNews() {
        RestTemplate restTemplate = new RestTemplate();

        URL url = new HttpUrl.Builder()
                .scheme("https")
                .host(newsApiProperties.getBaseHost())
                .addPathSegments("v2/top-headlines")
                .addQueryParameter("country", "ru")
                .addQueryParameter("from", getCurrentDate())
                .addQueryParameter("apiKey", newsApiProperties.getApiKey())
                .build().url();

        //todo: logBack лnоги добваить
        NewsResponse newsResponse = restTemplate.getForObject(url.toString(), NewsResponse.class);
        log.debug("Received weatherResponse '{}'", newsResponse);
        return newsResponse;
    }

}
