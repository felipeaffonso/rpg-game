package com.challenge.engine.actions;

import com.challenge.engine.fight.*;
import com.challenge.exception.CoffeeNirvanaException;
import com.challenge.exception.DeadCharacterException;
import com.challenge.model.Character;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class ReadNextMessageAction implements DuringGameAction {

    private final List<FightAction> fightActionStrategyList = asList(
            new GoCoffeeShopAction(),
            new FindMonsterBugAction(),
            new AnswerBossMomAction(),
            new FindDisturbingPersonAtPrinter());


    @Override
    public void executeAction(Character character) {
        try {
            final Random random = new Random();
            this.fightActionStrategyList.get(random.nextInt(this.fightActionStrategyList.size())).executeAction(character);
            character.printDetails();
            System.out.println();
        } catch(final DeadCharacterException | CoffeeNirvanaException e) {
            character.printDetails();
            throw e;
        } catch(final Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
