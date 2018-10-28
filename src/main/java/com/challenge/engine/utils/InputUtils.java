package com.challenge.engine.utils;

import com.challenge.exception.InvalidOptionException;

import java.util.Collection;
import java.util.Objects;
import java.util.Scanner;

public class InputUtils {

    private final static Scanner scanner = new Scanner(System.in);

    public static Integer validateIntegerInput(final Collection<Integer> availableOptions) {
        try {
            final Integer command = Integer.valueOf(scanner.nextLine());
            if (Objects.isNull(availableOptions) || !availableOptions.contains(command)) {
                throw new InvalidOptionException();
            }
            return command;
        } catch (final NumberFormatException e) {
            throw new InvalidOptionException();
        }
    }

    public static String validateStringInput() {
        try {
            final String input = scanner.nextLine();
            if (Objects.isNull(input) || input.trim().length() == 0) {
                throw new InvalidOptionException();
            }
            return input;
        } catch (final NumberFormatException e) {
            throw new InvalidOptionException();
        }
    }

    public static void clearConsole() {
        System.out.println("\n\n\n\n");
    }
}