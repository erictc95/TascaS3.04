package com.agenda.note.repository;

import com.agenda.note.model.Note;

import java.util.List;

public interface INoteRepository {

    void save(Note note);

    List<Note> findAll();

    void update(Note note);

    void delete(int noteId);

    Note findById(int noteId);

    List<Note> findByTitle(String title);

    List<Note> findByWord(String word);

}
