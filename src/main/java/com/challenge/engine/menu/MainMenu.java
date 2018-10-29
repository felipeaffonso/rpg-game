package com.challenge.engine.menu;

import com.challenge.engine.GameEngine;
import com.challenge.engine.utils.InputUtils;
import com.challenge.exception.CoffeeNirvanaException;
import com.challenge.exception.DeadCharacterException;
import com.challenge.exception.EndGameException;
import com.challenge.exception.InvalidOptionException;
import com.challenge.model.Character;

import static java.lang.String.format;

public class MainMenu {

    private final MenuActionFactory menuActionFactory;
    private final GameEngine gameEngine;
    private final InputUtils inputUtils;

    public MainMenu(final MenuActionFactory menuActionFactory,
                    final GameEngine gameEngine,
                    final InputUtils inputUtils) {
        this.menuActionFactory = menuActionFactory;
        this.gameEngine = gameEngine;
        this.inputUtils = inputUtils;
    }

    public void startGameMenu() {

        try {
            boolean choosingOptions;
            Character character = null;
            do {
                System.out.println("## Choose one of the following options ##");
                System.out.println("\tOption 1 - Start Game");
                System.out.println("\tOption 2 - Load Game");
                System.out.println("\tOption 3 - Exit Game");
                System.out.println("_______________________");

                System.out.print("Type your option: ");
                int command;
                try {
                    command = inputUtils.validateIntegerInput(this.menuActionFactory.getAvailableOptions());
                    character = this.menuActionFactory.findMenuAction(command).execute();
                    choosingOptions = false;
                } catch (final InvalidOptionException itm) {
                    System.err.println();
                    System.err.println("Invalid option, take another one");
                    choosingOptions = true;
                }
            } while (choosingOptions);
            gameEngine.startGame(character);
        } catch (final EndGameException | DeadCharacterException | CoffeeNirvanaException ege) {
            throw ege;
        } catch(final Exception ex) {
            System.err.println(format("Unexpected Game Over. I am very sorry about this error: %s", ex.getMessage()));
            throw new EndGameException(ex.getMessage());
        }
    }
}
