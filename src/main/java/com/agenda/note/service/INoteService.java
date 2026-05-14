package com.agenda.note.service;

import com.agenda.note.model.Note;

import java.util.List;

public interface INoteService {

    void createNote(String title, String description, int taskId);

    List<Note> getAllNotes();

    void update(int noteId, String newTitle, String newDescription, int taskId);

    void delete(int noteId);

    Note findById(int noteId);

    List<Note> findByTitle(String title);

    List<Note> findByWord(String word);
}
