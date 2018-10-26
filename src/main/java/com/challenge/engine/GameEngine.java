package com.challenge.engine;

import com.challenge.engine.sound.MusicPlayer;
import com.challenge.exception.EndGameException;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class GameEngine {

    private final Map<Integer, GameAction> gameActionMap = new HashMap<>();
    private final MusicPlayer musicPlayer = new MusicPlayer();

    public GameEngine(final GameFinisher gameFinisher, final GameLoader gameLoader, final GamePlayer gamePlayer) {
        this.gameActionMap.put(0, gameFinisher);
        this.gameActionMap.put(1, gamePlayer);
        this.gameActionMap.put(2, gameLoader);
    }

    public void startGame() {
        printWelcomeMessage();
        startGameSound();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            do {
                System.out.println("## Choose one of the following options ##");
                System.out.println("Option 1 - Start Game");
                System.out.println("Option 2 - Load Game");
                System.out.println("Option 0 - Exit Game");
                System.out.println("_______________________");

                System.out.print("Type your option: ");
                int command;
                try {
                    command = Integer.valueOf(scanner.nextLine());
                    running = gameActionMap.get(command).execute();
                } catch (final Exception itm) {
                    System.err.println("Invalid option, take another one");
                    running = true;
                }

            } while(running);
        } catch(final EndGameException ege) {
            System.out.println("Thanks for Playing my Game");
        }
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to my game!");
    }

    public void startGameSound() {
        this.musicPlayer.makeSomeNoise();
    }
}
