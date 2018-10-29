package com.challenge.engine.fight;

import com.challenge.engine.utils.FileUtils;
import com.challenge.model.Character;

import java.util.Random;

public class AnswerBossMomAction implements FightAction {

    private final FileUtils fileUtils;

    private final Random random;

    public AnswerBossMomAction(final FileUtils fileUtils, final Random random) {
        this.fileUtils = fileUtils;
        this.random = random;
    }

    @Override
    public void executeAction(Character character) {
        final int problems = this.random.nextInt(10) + 1;
        System.out.println("Your boss mom is very cute!");
        this.fileUtils.waitSeconds(2);
        System.out.println("She brought coffees and problems");
        this.fileUtils.waitSeconds(1);
        System.out.println(".....");
        this.fileUtils.waitSeconds(2);
        System.out.println("You have to solve " + problems + " nice bugs");
        this.fileUtils.waitSeconds(3);
        System.out.println("DOUBLE COFFEE for each corrected bug!");
        final int solvedProblems = this.random.nextInt(problems);
        final int coffeesWon = solvedProblems * 2;
        final int damage = problems - solvedProblems;
        System.out.println("OH, MOMMY! You have fixed " + solvedProblems + " that gives you " + coffeesWon + " coffees!");
        this.fileUtils.waitSeconds(3);
        System.out.println("But you lost " + damage + " caffeine cells from your body.");
        character.drinkCoffee(coffeesWon);
        character.receiveDamage(damage);
        this.fileUtils.waitSeconds(2);
    }

}