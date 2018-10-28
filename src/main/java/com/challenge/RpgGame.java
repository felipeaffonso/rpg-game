package com.challenge;

public class RpgGame {

    protected RpgGame() {
        super();
    }

    public static void main(String[] args) {
        printWelcomeMessage();
        try {
            new GameApplication()
                    .setup()
                    .startGameMenu();
        } catch (final Exception egx) {
            System.err.println(egx.getMessage());
        } finally {
            System.exit(-1);
        }
    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to my game!");
    }
}
