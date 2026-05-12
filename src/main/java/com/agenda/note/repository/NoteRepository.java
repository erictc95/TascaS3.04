package com.agenda.note.repository;

import com.agenda.note.model.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
            if (notes.get(i).getId().equals(updatedNote.getId())) {
                notes.set(i, updatedNote);
            }
        }
    }

    public void deleteNote(UUID id) {
        notes.removeIf(note -> note.getId().equals(id));
    }

    public Note findById(UUID id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Note> findByTitle(String title) {
       return notes.stream().filter(note -> note.getTitle().equals(title)).toList();
    }

    public List<Note> findByWord(String word) {
        return notes.stream().filter(note -> note.getDescription().contains(word)).toList();
    }
}
