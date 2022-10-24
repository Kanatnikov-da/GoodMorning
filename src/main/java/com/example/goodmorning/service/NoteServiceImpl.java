package com.example.goodmorning.service;

import com.example.goodmorning.domain.NoteInfo;
import com.example.goodmorning.domain.entiity.NoteEntity;
import com.example.goodmorning.exception.NotFoundException;
import com.example.goodmorning.repository.NotesRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NotesRepo notesRepo;

    @Override
    public List<NoteInfo> getNotes() {
        LocalDate currentDate = LocalDate.now();
        log.info("getting notes by current date: {}", currentDate);
        List<NoteInfo> notesList = notesRepo.findAllByCreated(currentDate)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
        log.info("Received notes '{}'", notesList);
        return notesList;
    }

    @Override
    public NoteInfo getNote(Long id) {
        return notesRepo.findById(id)
                .map(this::map)
                .orElseThrow(() -> new NotFoundException(String.format("Note with id '%d' was not found", id)));
    }

    private NoteInfo map(NoteEntity entity) {
        //todo replace with mapstruct
        NoteInfo noteInfo = new NoteInfo();
        noteInfo.setId(entity.getId());
        noteInfo.setNote(entity.getText());
        noteInfo.setDate(entity.getCreated());
        return noteInfo;
    }
}
