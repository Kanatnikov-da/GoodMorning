package com.example.goodmorning.service;

import com.example.goodmorning.domain.NoteInfo;

import java.util.List;

public interface NoteService {
    List<NoteInfo> getNotes();

    NoteInfo getNote(Long id);
}
