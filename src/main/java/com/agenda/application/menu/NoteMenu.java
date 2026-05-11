package com.agenda.application.menu;

import java.util.Scanner;

public class NoteMenu {

    private static Scanner scanner = new Scanner(System.in);

    public void show() {

        int option;

        do {

            System.out.println("--> WELCOME TO YOUR CLI AGENDA <--");
            System.out.println();
            System.out.println("1. Manage Tasks");
            System.out.println("2. Manage Events");
            System.out.println("3. Manage Notes");
            System.out.println("4. Manage Events");
            System.out.println("5. Manage Notes");
            System.out.println("0. Back");
            System.out.println();
            System.out.print("Select an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:
                    System.out.println("Going Back");
                    break;
                default:
                    System.out.println("Invalid Option. Try again.");
            }

        } while (option != 0);

    }
}
