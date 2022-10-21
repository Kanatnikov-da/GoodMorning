package com.example.goodmorning.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "news-api")
public class NewsApiProperties {
    private String baseHost;
    private String apiKey;
}
