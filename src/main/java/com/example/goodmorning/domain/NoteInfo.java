package com.example.goodmorning.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteInfo {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("note")
    private String note;
    @JsonProperty("date")
    private LocalDate date;
}
