package com.example.goodmorning.domain.entiity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class NoteEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String notes;
    private LocalDate date;


    public NoteEntity() {

    }

    public NoteEntity(String notes, LocalDate date) {
        this.notes = notes;
        this.date = date;
    }
}
