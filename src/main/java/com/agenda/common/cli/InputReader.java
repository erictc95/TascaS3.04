package com.agenda.common.cli;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputReader {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ERROR_MESSAGE = "Format error. Try it again.";
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    public static int readInt(String message) {
        while(true) {
            System.out.println(message);
            int var1;
            try {
                var1 = SCANNER.nextInt();
            } catch (InputMismatchException var5) {
                System.out.println(ERROR_MESSAGE);
                continue;
            } finally {
                SCANNER.nextLine();
            }
            return var1;
        }
    }

    public static String readNonEmptyString(String message) {
        while(true) {
            System.out.println(message);
            String str = SCANNER.nextLine().trim();
            if (!str.isEmpty()) {
                return str;
            }
        }
    }

    public static String readString(String message) {
            System.out.println(message);
            return SCANNER.nextLine().trim();
    }

    public static <T extends Enum<T>> T readEnum(String message, Class<T> enumClass) {
        String validValues = Arrays.stream(enumClass.getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.joining(", "));

        while (true) {
            System.out.print(message);
            String input = SCANNER.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println(ERROR_MESSAGE+ " " + validValues);
                continue;
            }

            try {
                return Enum.valueOf(enumClass, input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE+ " " + validValues);
            }
        }
    }

    public static LocalDateTime readDateTime(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println(ERROR_MESSAGE);
                continue;
            }

            try {
                return LocalDateTime.parse(input, DATE_TIME_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println( ERROR_MESSAGE + " (yyyy-MM-dd HH:mm)");
            }
        }
    }

    public static LocalDateTime readOptionalDateTime(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();

            if (input.isEmpty()) {
                return null;
            }

            try {
                return LocalDateTime.parse(input, DATE_TIME_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println( ERROR_MESSAGE + " (yyyy-MM-dd HH:mm)");
            }
        }
    }

}
