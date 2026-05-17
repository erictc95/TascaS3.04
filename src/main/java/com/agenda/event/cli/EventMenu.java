package com.agenda.event.cli;

import com.agenda.common.cli.InputReader;
import com.agenda.event.dto.CreateEventCommand;
import com.agenda.event.model.EventRepeatType;
import com.agenda.event.service.EventService;

import java.sql.SQLOutput;
import java.time.LocalDateTime;

public class EventMenu {

    private final EventService eventService;

    public EventMenu(EventService eventService) {
        this.eventService = eventService;
    }


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

            option = InputReader.readInt("Select an option: ");

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
        String name = InputReader.readNonEmptyString("Name: ");
        String description = InputReader.readString("Description: ");
        LocalDateTime start = InputReader.readDateTime("Start date (yyyy-MM-dd HH:mm): ");
        LocalDateTime end = InputReader.readOptionalDateTime("End date (yyyy-MM-dd HH:mm): ");
        String location = InputReader.readString("Location: ");
        EventRepeatType repeatType = InputReader.readEnum("Repeat type (NONE, YEARLY, CUSTOM): ", EventRepeatType.class);
        int customRepeat = 0;
        if (repeatType == EventRepeatType.CUSTOM) {
            customRepeat = InputReader.readInt("Custom days: ");
        }

        Integer notificationMinutes = InputReader.readOptionalInt("Notification minutes: ");

        CreateEventCommand newEvent = new CreateEventCommand(
                name,
                description,
                start,
                end,
                location,
                repeatType,
                customRepeat,
                notificationMinutes
        );

        int id = eventService.createEvent(newEvent);

        System.out.println("Event created with id: " + id);
    }
}
