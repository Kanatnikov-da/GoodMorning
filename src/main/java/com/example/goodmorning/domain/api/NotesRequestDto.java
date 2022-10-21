package com.example.goodmorning.domain.api;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NotesRequestDto {
    private String notes;
    private LocalDate date;
}
