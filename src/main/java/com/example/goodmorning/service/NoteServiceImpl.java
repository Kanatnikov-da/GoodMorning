package com.example.goodmorning.service;

import com.example.goodmorning.domain.entiity.NoteEntity;
import com.example.goodmorning.repository.NotesRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static com.example.goodmorning.utils.Utils.getCurrentDateISO;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NotesRepo notesRepo;

    @Override
    public List<String> getNotes() {
        List<String> notesList = notesRepo.findByDate(getCurrentDateISO())
                .stream()
                .map(NoteEntity::getNotes)
                .collect(Collectors.toList());
        log.info("Received notes '{}'", notesList);
        return notesList;
    }
}
