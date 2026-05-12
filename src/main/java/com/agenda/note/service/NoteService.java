package com.agenda.note.service;

import com.agenda.note.model.Note;
import com.agenda.note.repository.NoteRepository;

import java.util.List;
import java.util.UUID;

public class NoteService {

    NoteRepository noteRepository = new NoteRepository();

    public void createNote(String title, String description) {

    }

    public List<Note> getAllNotes() {

    }

    public Note updateNote(Note note) {

    }

    public void deleteNote(UUID id) {

    }

    public Note findById(UUID id) {

    }

    public Note findByTitle(String title) {

    }

    public Note findByWord(String word) {

    }

}
