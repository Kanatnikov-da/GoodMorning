package com.example.goodmorning.domain.newsApi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NewsResponse {
    @JsonProperty("status")
    public String status;
    @JsonProperty("totalResults")
    public int totalResults;
    @JsonProperty("articles")
    public List<Article> articles;
}

