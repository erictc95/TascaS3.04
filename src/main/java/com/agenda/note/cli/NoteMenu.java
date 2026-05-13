package com.agenda.note.cli;

import com.agenda.note.model.Note;
import com.agenda.note.service.NoteService;

import java.util.List;
import java.util.Scanner;

public class NoteMenu {

    private static Scanner scanner = new Scanner(System.in);
    private NoteService noteService = new NoteService();

    public void show() {

        int option;

        do {

            System.out.println("--> NOTE MENU <--");
            System.out.println();
            System.out.println("1. Create Note");
            System.out.println("2. List Notes");
            System.out.println("3. Update Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Search Note");
            System.out.println("0. Back");
            System.out.println();
            System.out.print("Select an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createNote();
                    break;
                case 2:
                    listNotes();
                    System.out.println("Listing Notes");
                    break;
                case 3:
                    updateNote();
                    System.out.println("Updating Note");
                    break;
                case 4:
                    deleteNote();
                    System.out.println("Deleting Note");
                    break;
                case 5:
                    searchMenu();
                    System.out.println("Searching Note");
                    break;
                case 0:
                    System.out.println("Going Back");
                    break;
                default:
                    System.out.println("Invalid Option. Try again.");
            }

        } while (option != 0);

    }


    private void createNote() {
        System.out.println("Title: ");
        String title = scanner.nextLine();

        System.out.println("Description: ");
        String description = scanner.nextLine();

        System.out.println("Task id:");
        Long taskId = scanner.nextLong();

        noteService.createNote(title, description, taskId);
    }

    private void listNotes() {
        System.out.println("List of Notes: ");
        List<Note> theList = noteService.getAllNotes();

        showNotesList(theList);
    }

    private void updateNote() {
        System.out.println("Note Id?");
        Long noteId = scanner.nextLong();

        System.out.println("New Title: ");
        String newTitle = scanner.nextLine();

        System.out.println("New Description");
        String newDescription = scanner.nextLine();

        noteService.updateNote(noteId, newTitle, newDescription);
    }

    private void validateLongNumber() {
        Long noteId;
    }


    private void deleteNote() {
        Long noteId = null;

        noteService.deleteNote(noteId);
    }

    private void searchMenu() {
        int option;

        do {

            System.out.println("--> SEARCH MENU <--");
            System.out.println();
            System.out.println("1. Search Note by Id");
            System.out.println("2. Search Note by Title");
            System.out.println("3. Search Note by Word");
            System.out.println("0. Back");
            System.out.println();
            System.out.print("Select an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    searchById();
                    break;
                case 2:
                    searchByTitle();
                    break;
                case 3:
                    searchByWord();
                    break;
                case 0:
                    System.out.println("Going Back");
                    break;
                default:
                    System.out.println("Invalid Option. Try again.");
            }

        } while (option != 0);
    }

    private void searchById() {
        Long noteId = null;

        Note resultNote;

        resultNote = noteService.findById(noteId);

        if (resultNote != null) {
            System.out.println(resultNote);
        } else {
            System.out.println("Note not found!");
        }
    }

    private void searchByTitle() {
        System.out.println("Enter the Title of Note to Search: ");
        String title = scanner.nextLine();

        List<Note> foundList = noteService.findByTitle(title);

        showNotesList(foundList);
    }

    private void searchByWord() {
        System.out.println("Enter the Words of Note to Search: ");
        String word = scanner.nextLine();

        List<Note> foundList = noteService.findByWord(word);

        showNotesList(foundList);
    }

    private void printNotesList(List<Note> foundNotes) {
        foundNotes.forEach(System.out::println);
    }

    private void showNotesList (List<Note> allNotes) {
        if (allNotes.isEmpty()) {
            System.out.println("The List is Empty");
        } else {
            printNotesList(allNotes);
        }
    }
}
