package com.challenge.engine.menu;

import com.challenge.engine.GameEngine;
import com.challenge.engine.utils.FileUtils;
import com.challenge.engine.utils.InputUtils;
import com.challenge.exception.CoffeeNirvanaException;
import com.challenge.exception.DeadCharacterException;
import com.challenge.exception.EndGameException;
import com.challenge.exception.InvalidOptionException;
import com.challenge.model.Character;

public class MainMenu {

    private final MenuActionFactory menuActionFactory;
    private final GameEngine gameEngine;
    private final InputUtils inputUtils;
    private final FileUtils fileUtils;

    public MainMenu(final MenuActionFactory menuActionFactory,
                    final GameEngine gameEngine,
                    final InputUtils inputUtils,
                    final FileUtils fileUtils) {
        this.menuActionFactory = menuActionFactory;
        this.gameEngine = gameEngine;
        this.inputUtils = inputUtils;
        this.fileUtils = fileUtils;
    }

    public void startGameMenu() {

        try {
            boolean choosingOptions;
            Character character = null;
            do {
                this.printMenuTitle();
                System.out.println(this.fileUtils.getString("game.menu"));
                System.out.print(this.fileUtils.getString("game.typeOption"));
                int command;
                try {
                    command = inputUtils.validateIntegerInput(this.menuActionFactory.getAvailableOptions());
                    character = this.menuActionFactory.findMenuAction(command).execute();
                    choosingOptions = false;
                } catch (final InvalidOptionException itm) {
                    System.err.println(this.fileUtils.getString("game.error.invalidOption"));
                    choosingOptions = true;
                }
            } while (choosingOptions);
            gameEngine.startGame(character);
        } catch (final EndGameException | DeadCharacterException | CoffeeNirvanaException ege) {
            throw ege;
        } catch(final Exception ex) {
            System.err.println(ex.getMessage());
            throw new EndGameException(ex.getMessage());
        }
    }

    private void printMenuTitle() {
        System.out.println(
                "\t\t\t╔═╗┬  ┌─┐┌─┐┌─┐┌─┐  ┌─┐┌─┐┬  ┌─┐┌─┐┌┬┐\n" +
                "\t\t\t╠═╝│  ├┤ ├─┤└─┐├┤   └─┐├┤ │  ├┤ │   │ \n" +
                "\t\t\t╩  ┴─┘└─┘┴ ┴└─┘└─┘  └─┘└─┘┴─┘└─┘└─┘ ┴ ");
    }
}
