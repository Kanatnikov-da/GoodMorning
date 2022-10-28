package com.example.goodmorning.service.shedulingService;

import com.example.goodmorning.repository.NotesRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteOldNotesServiceImpl implements DeleteOldNotesService {

    private final NotesRepo notesRepo;

    @Scheduled(initialDelay = 2000, fixedDelayString = "PT12H")
    public void deleteOldNotes(){
        log.info("delete old notes begin");
        LocalDate currentDate = LocalDate.now();
        notesRepo.deleteLoggingTimeStampBeforeAndByDomain(currentDate);
        log.info("delete old notes finished");
    }

}
