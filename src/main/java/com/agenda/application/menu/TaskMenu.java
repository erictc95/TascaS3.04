package com.agenda.application.menu;

import java.util.Scanner;

public class TaskMenu {

    private static Scanner scanner = new Scanner(System.in);

    public void show() {

        int option;

        do {

            System.out.println("--> TASK MENU <--");
            System.out.println();
            System.out.println("1. Create Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. Filter Task by Priority");
            System.out.println("7. Filter Task by State");
            System.out.println("8. Filter Task by Date Proximity");
            System.out.println("0. Back");
            System.out.println();
            System.out.print("Select an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:

                    System.out.println("Creating Task...");
                    break;
                case 2:
                    System.out.println("Listing Tasks...");
                    break;
                case 3:
                    System.out.println("Updating Task...");
                    break;
                case 4:
                    System.out.println("Deleting Task...");
                    break;
                case 5:
                    System.out.println("Marked Task...");
                    break;
                case 6:
                    System.out.println("Filtering Task...");
                    break;
                case 7:
                    System.out.println("Filtering Task...");
                    break;
                case 8:
                    System.out.println("Filtering Task...");
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
