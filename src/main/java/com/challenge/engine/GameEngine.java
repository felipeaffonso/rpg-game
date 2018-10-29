package com.challenge.engine;

import com.challenge.engine.actions.DuringGameAction;
import com.challenge.engine.actions.DuringGameActionFactory;
import com.challenge.engine.utils.InputUtils;
import com.challenge.exception.EndGameException;
import com.challenge.exception.InvalidOptionException;
import com.challenge.model.Character;

import static java.lang.String.format;

public class GameEngine {

    private final DuringGameActionFactory duringGameActionFactory;
    private final InputUtils inputUtils;

    public GameEngine(final DuringGameActionFactory duringGameActionFactory, final InputUtils inputUtils) {
        this.duringGameActionFactory = duringGameActionFactory;
        this.inputUtils = inputUtils;
    }

    public void startGame(final Character character) {
        System.out.println(format("Your journey is only beginning %s, The %s programmer",
                character.getName(),
                character.getClazz().getLanguage()));

        System.out.println();

        try{
            do {
                System.out.println("_______________________");
                printOptions();
                System.out.print("Choose your path: ");

                try {
                    final Integer command = inputUtils.validateIntegerInput(duringGameActionFactory.getAvailableOptions());
                    final DuringGameAction duringGameAction = this.duringGameActionFactory.findDuringGameAction(command);
                    duringGameAction.executeAction(character);

                } catch(final InvalidOptionException ioe) {
                    System.err.println("Invalid Option!");
                    System.err.println();
                }

            } while(true);
        } catch(final EndGameException ege) {
            throw ege;
        }

    }

    private void printOptions() {
        System.out.println("There are so many Slack messages coming");
        System.out.println("What are you going to do?");
        System.out.println("\t1) Read the next message and count on your lucky!");
        System.out.println("\t2) Save your game process and continue another time.");
        System.out.println("\t3) Simply abandon the game without saving any progress");
    }

}