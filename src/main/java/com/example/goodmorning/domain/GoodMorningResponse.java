package com.example.goodmorning.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodMorningResponse {
   @JsonProperty("titleNews")
   private List<String> titleNews;
   @JsonProperty("weatherInfo")
   private WeatherInfo weatherInfo;
   @JsonProperty("notes")
   private List<NoteInfo> notes;
}
