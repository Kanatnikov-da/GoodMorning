package com.example.goodmorning.repository;

import com.example.goodmorning.domain.entiity.NoteEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface NotesRepo extends CrudRepository<NoteEntity, Long> {
    List<NoteEntity> findByDate(LocalDate date);
}
