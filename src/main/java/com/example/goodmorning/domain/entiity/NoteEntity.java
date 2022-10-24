package com.example.goodmorning.domain.entiity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "notes")
@NoArgsConstructor
public class NoteEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String text;
    private LocalDate created;

    public NoteEntity(String text, LocalDate created) {
        this.text = text;
        this.created = created;
    }
}
