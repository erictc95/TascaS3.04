package com.agenda.note.service;

import com.agenda.note.model.Note;
import com.agenda.note.repository.NoteRepository;

import java.util.List;

public class NoteService {

    NoteRepository noteRepository = new NoteRepository();

    public void createNote(String title, String description, int taskId) {
        noteRepository.saveNote(new Note(0, title, description, taskId));
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public void updateNote(int noteId, String newTitle, String newDescription, int taskId) {
        noteRepository.updateNote(new Note(noteId, newTitle, newDescription, 0));
    }

    public void deleteNote(int noteId) {
        noteRepository.deleteNote(noteId);
    }

    public Note findById(int noteId) {
        return noteRepository.findById(noteId);
    }

    public List<Note> findByTitle(String title) {
        return noteRepository.findByTitle(title);
    }

    public List<Note> findByWord(String word) {
        return noteRepository.findByWord(word);
    }

}
