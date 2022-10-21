package com.example.goodmorning.domain.newsApi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Article {
    @JsonProperty("source")
    public Source source;
    @JsonProperty("author")
    public String author;
    @JsonProperty("title")
    public String title;
    @JsonProperty("description")
    public String description;
    @JsonProperty("url")
    public String url;
    @JsonProperty("urlToImage")
    public String urlToImage;
    @JsonProperty("publishedAt")
    public String publishedAt;
    @JsonProperty("content")
    public String content;
}
