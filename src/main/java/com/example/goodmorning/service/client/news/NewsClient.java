package com.example.goodmorning.service.client.news;

import com.example.goodmorning.domain.newsApi.response.NewsResponse;

public interface NewsClient {
    NewsResponse getNews();
}
