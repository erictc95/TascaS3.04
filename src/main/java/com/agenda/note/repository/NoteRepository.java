package com.agenda.note.repository;

import com.agenda.note.model.Note;

import java.util.ArrayList;
import java.util.List;


public class NoteRepository {

    private List<Note> notes = new ArrayList<>();

    public void saveNote(Note note) {
        notes.add(note);
        System.out.println("Note Created!");
    }

    public List<Note> findAll() {
        return notes;
    }

    public void updateNote(Note updatedNote) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == updatedNote.getId()) {
                notes.set(i, updatedNote);
            }
        }
    }

    public void deleteNote(int noteId) {
        notes.removeIf(note -> note.getId() == noteId);
    }

    public Note findById(int noteId) {
        return notes.stream().filter(note -> note.getId() == noteId).findFirst().orElse(null);
    }

    public List<Note> findByTitle(String title) {
       return notes.stream().filter(note -> note.getTitle().equals(title)).toList();
    }

    public List<Note> findByWord(String word) {
        return notes.stream().filter(note -> note.getDescription().contains(word)).toList();
    }
}
