package com.agenda.note.cli;

import com.agenda.note.service.NoteService;

import java.util.Scanner;

public class NoteMenu {

    private static Scanner scanner = new Scanner(System.in);

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
                    System.out.println("Creating Note");
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
                    searchNote();
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


    }

    private void listNotes() {

    }

    private void updateNote() {

    }

    private void deleteNote() {

    }

    private void searchNote() {

    }
}
