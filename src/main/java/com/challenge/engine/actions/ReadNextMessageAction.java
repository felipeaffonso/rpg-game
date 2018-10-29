package com.challenge.engine.actions;

import com.challenge.engine.fight.FightAction;
import com.challenge.engine.fight.FightActionFactory;
import com.challenge.exception.CoffeeNirvanaException;
import com.challenge.exception.DeadCharacterException;
import com.challenge.exception.EndGameException;
import com.challenge.model.Character;

import java.util.Random;

public class ReadNextMessageAction implements DuringGameAction {

    private final FightActionFactory fightActionFactory;

    private final Random random;

    public ReadNextMessageAction(final Random random, final FightActionFactory fightActionFactory) {
        this.random = random;
        this.fightActionFactory = fightActionFactory;
    }

    @Override
    public void executeAction(final Character character) {
        try {
            final int possibleRange = this.fightActionFactory.getAvailableOptions().size() -1;
            final int randomNumber = this.random.nextInt(possibleRange);
            final FightAction fightAction = this.fightActionFactory.findFightAction(randomNumber);
            fightAction.executeAction(character);
            character.printDetails();
            System.out.println("\n");
        } catch(final DeadCharacterException | CoffeeNirvanaException e) {
            character.printDetails();
            throw e;
        } catch(final Exception e) {
            throw new EndGameException("Unexpected Game Over");
        }
    }
}
