package com.agenda.application.menu;

import com.agenda.note.cli.NoteMenu;
import com.agenda.note.repository.INoteRepository;
import com.agenda.note.repository.NoteInMemoryRepository;
import com.agenda.note.service.NoteService;

public class Main {

    public static void main(String[] args) {
        INoteRepository repository = new NoteInMemoryRepository();

        NoteService service = new NoteService(repository);

        NoteMenu noteMenu = new NoteMenu(service);

        MainMenu mainMenu = new MainMenu(noteMenu);

        mainMenu.start();
    }
}
