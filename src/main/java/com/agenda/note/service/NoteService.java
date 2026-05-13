package com.agenda.note.service;

import com.agenda.note.model.Note;
import com.agenda.note.repository.NoteRepository;

import java.util.List;

public class NoteService {

    NoteRepository noteRepository = new NoteRepository();

    public void createNote(String title, String description, Long taskId) {
        noteRepository.saveNote(new Note(null, title, description, taskId));
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public void updateNote(Long noteId, String newTitle, String newDescription) {
        noteRepository.updateNote(new Note(noteId, newTitle, newDescription, null));
    }

    public void deleteNote(Long noteId) {
        noteRepository.deleteNote(noteId);
    }

    public Note findById(Long noteId) {
        return noteRepository.findById(noteId);
    }

    public List<Note> findByTitle(String title) {
        return noteRepository.findByTitle(title);
    }

    public List<Note> findByWord(String word) {
        return noteRepository.findByWord(word);
    }

}
