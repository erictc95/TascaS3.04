package com.agenda.event.cli;

import java.util.Scanner;

public class EventMenu {

    private static Scanner scanner = new Scanner(System.in);

    public void show() {

        int option;

        do {

            System.out.println("--> EVENT MENU <--");
            System.out.println();
            System.out.println("1. Create Event");
            System.out.println("2. List Events");
            System.out.println("3. Update Event");
            System.out.println("4. Delete Events");
            System.out.println("5. Search Event by Date");
            System.out.println("0. Back");
            System.out.println();
            System.out.print("Select an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Creating Event...");
                    createEvent();
                    break;
                case 2:
                    System.out.println("Listing Events...");
                    listTasks();
                    break;
                case 3:
                    System.out.println("Updating Event...");

                    break;
                case 4:
                    System.out.println("Deleting Event...");
                    break;
                case 5:
                    System.out.println("Searching Event...");
                    break;
                case 0:
                    System.out.println("Going Back");
                    break;
                default:
                    System.out.println("Invalid Option. Try again.");
            }

        } while (option != 0);

    }

    private void listTasks() {
    }

    private void createEvent() {
    }
}
