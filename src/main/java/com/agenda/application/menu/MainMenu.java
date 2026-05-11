package com.agenda.application.menu;

import java.util.Scanner;

public class MainMenu {

    private static Scanner scanner = new Scanner(System.in);

    public void start() {
        int option;

        do {

            System.out.println("--> WELCOME TO YOUR CLI AGENDA <--");
            System.out.println();
            System.out.println("1. Manage Tasks");
            System.out.println("2. Manage Events");
            System.out.println("3. Manage Notes");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Select an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    new TaskMenu().show();
                    break;
                case 2:
                    new EventMenu().show();
                    break;
                case 3:
                    new NoteMenu().show();
                    break;
                case 0:
                    System.out.println("See you soon!");
                    break;
                default:
                    System.out.println("Invalid Option. Try again.");
            }

        } while (option != 0);

    }
}
