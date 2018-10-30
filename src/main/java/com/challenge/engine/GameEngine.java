package com.challenge.engine;

import com.challenge.engine.actions.DuringGameAction;
import com.challenge.engine.actions.DuringGameActionFactory;
import com.challenge.engine.utils.FileUtils;
import com.challenge.engine.utils.InputUtils;
import com.challenge.exception.EndGameException;
import com.challenge.exception.InvalidOptionException;
import com.challenge.model.Character;

import static java.text.MessageFormat.format;

public class GameEngine {

    private final DuringGameActionFactory duringGameActionFactory;
    private final InputUtils inputUtils;
    private final FileUtils fileUtils;

    public GameEngine(final DuringGameActionFactory duringGameActionFactory, final InputUtils inputUtils,
                      final FileUtils fileUtils) {
        this.duringGameActionFactory = duringGameActionFactory;
        this.inputUtils = inputUtils;
        this.fileUtils = fileUtils;
    }

    public void startGame(final Character character) {
        fileUtils.waitSeconds(2);
        System.out.println(format(fileUtils.getString("game.journeyBeginning"),
                character.getName(),
                character.getClazz().getLanguage()));

        try{

            do {
                System.out.println(this.fileUtils.getString("game.duringGameMenu"));
                System.out.print(this.fileUtils.getString("game.typeOption"));

                try {
                    final Integer command = inputUtils.validateIntegerInput(duringGameActionFactory.getAvailableOptions());
                    final DuringGameAction duringGameAction = this.duringGameActionFactory.findDuringGameAction(command);
                    duringGameAction.executeAction(character);

                } catch(final InvalidOptionException ioe) {
                    System.err.println(fileUtils.getString("game.error.invalidOption"));
                    System.err.println();
                }

            } while(true);
        } catch(final EndGameException ege) {
            throw ege;
        }

    }

}