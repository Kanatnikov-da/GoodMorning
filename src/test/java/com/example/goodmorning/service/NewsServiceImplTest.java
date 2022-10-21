package com.example.goodmorning.service;

import com.example.goodmorning.domain.newsApi.response.Article;
import com.example.goodmorning.domain.newsApi.response.NewsResponse;
import com.example.goodmorning.service.client.news.NewsClient;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = NewsServiceImpl.class)
class NewsServiceImplTest {

    @Autowired
    private NewsService newsService;
    @MockBean
    private NewsClient newsClient;

    @Test
    void getTodayNews() {
        EasyRandom easyRandom = new EasyRandom();
        NewsResponse newsResponse = easyRandom.nextObject(NewsResponse.class);
        Mockito.doReturn(newsResponse).when(newsClient).getNews();

        List<String> actual = newsService.getTodayNews();
        List<Article> expectedArticles = newsResponse.getArticles();
        assertEquals(expectedArticles.size(), actual.size());
        expectedArticles.forEach(expectedArticle ->
                assertTrue(actual.contains(expectedArticle.getTitle())));
    }
}