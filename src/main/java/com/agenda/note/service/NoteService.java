package com.agenda.note.service;

import com.agenda.note.model.Note;
import com.agenda.note.repository.INoteRepository;

import java.util.List;

public class NoteService implements INoteService  {

    private final INoteRepository noteRepository;

    public NoteService(INoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void createNote(String title, String description, int taskId) {
        noteRepository.save(new Note(0, title, description, taskId));
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public void update(int noteId, String newTitle, String newDescription, int taskId) {
        noteRepository.update(new Note(noteId, newTitle, newDescription, taskId));
    }

    @Override
    public void delete(int noteId) {
        noteRepository.delete(noteId);
    }

    @Override
    public Note findById(int noteId) {
        return noteRepository.findById(noteId);
    }

    @Override
    public List<Note> findByTitle(String title) {
        return noteRepository.findByTitle(title);
    }

    @Override
    public List<Note> findByWord(String word) {
        return noteRepository.findByWord(word);
    }

}
