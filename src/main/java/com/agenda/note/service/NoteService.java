package com.agenda.note.service;

import com.agenda.note.model.Note;
import com.agenda.note.repository.NoteRepository;

import java.util.List;
import java.util.UUID;

public class NoteService {

    NoteRepository noteRepository = new NoteRepository();

    public void createNote(String title, String description) {
        noteRepository.saveNote(new Note(UUID.randomUUID(), title, description));
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public void updateNote(UUID id, String newTitle, String newDescription) {
        noteRepository.updateNote(new Note(id, newTitle, newDescription));
    }

    public void deleteNote(UUID id) {
        noteRepository.deleteNote(id);
    }

    public Note findById(UUID id) {
        return noteRepository.findById(id);
    }

    public List<Note> findByTitle(String title) {
        return noteRepository.findByTitle(title);
    }

    public List<Note> findByWord(String word) {
        return noteRepository.findByWord(word);
    }

}
