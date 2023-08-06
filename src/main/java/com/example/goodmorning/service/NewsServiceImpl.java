package com.example.goodmorning.service;

import com.example.goodmorning.domain.newsApi.response.Article;
import com.example.goodmorning.domain.newsApi.response.NewsResponse;
import com.example.goodmorning.service.client.news.NewsClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsClient newsClient;

    @Override
    @Cacheable("news")
    public List<String> getTodayNews() {
        log.info("getting todayNews");
        List<String> newsHeaders = Optional.ofNullable(newsClient.getNews())
                .map(NewsResponse::getArticles)
                .map(Collection::stream)
                .orElseGet(Stream::empty)
                .map(Article::getTitle)
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(newsHeaders)) {
            ArrayList<String> response = new ArrayList<>();
            response.add("На сегодня новостей больше нет");
            return response;
        }
        log.info("getting todayNews finished");
        return newsHeaders;
    }
}
