package com.example.goodmorning.domain.newsApi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Source {
    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
}
