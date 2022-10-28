package com.example.goodmorning.repository;

import com.example.goodmorning.domain.entiity.NoteEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface NotesRepo extends CrudRepository<NoteEntity, Long> {
    List<NoteEntity> findAllByCreated(LocalDate created);
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Modifying
    @Query("Delete from NoteEntity WHERE created < :currentDate")
    void deleteLoggingTimeStampBeforeAndByDomain(@Param("currentDate") LocalDate currentDate);


}
