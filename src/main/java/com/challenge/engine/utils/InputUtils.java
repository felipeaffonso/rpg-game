package com.challenge.engine.utils;

import com.challenge.exception.InvalidOptionException;

import java.util.Collection;
import java.util.Objects;
import java.util.Scanner;

public class InputUtils {

    private final Scanner scanner;

    public InputUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer validateIntegerInput(final Collection<Integer> availableOptions) {
        try {
            final Integer command = Integer.valueOf(scanner.next());
            if (Objects.isNull(availableOptions) || !availableOptions.contains(command)) {
                throw new InvalidOptionException();
            }
            return command;
        } catch (final Exception e) {
            throw new InvalidOptionException();
        }
    }

    public String validateStringInput() {
        try {
            final String input = scanner.next();
            if (Objects.isNull(input) || input.trim().length() == 0) {
                throw new InvalidOptionException();
            }
            return input;
        } catch (final Exception e) {
            throw new InvalidOptionException();
        }
    }

}