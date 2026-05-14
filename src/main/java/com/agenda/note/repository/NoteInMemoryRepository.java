package com.agenda.note.repository;

import com.agenda.note.model.Note;

import java.util.ArrayList;
import java.util.List;


public class NoteInMemoryRepository implements INoteRepository {

    private List<Note> notes = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void save(Note note) {
        note.setId(nextId++);
        notes.add(note);
        System.out.println("Note Created!");
    }

    public List<Note> findAll() {
        return notes;
    }

    @Override
    public void update(Note updatedNote) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == updatedNote.getId()) {
                notes.set(i, updatedNote);
            }
        }
    }

    @Override
    public void delete(int noteId) {
        notes.removeIf(note -> note.getId() == noteId);
    }

    @Override
    public Note findById(int noteId) {
        return notes.stream().filter(note -> note.getId() == noteId).findFirst().orElse(null);
    }

    @Override
    public List<Note> findByTitle(String title) {
       return notes.stream().filter(note -> note.getTitle().equals(title)).toList();
    }

    @Override
    public List<Note> findByWord(String word) {
        return notes.stream().filter(note -> note.getDescription().contains(word)).toList();
    }
}
