package com.challenge.engine.fight;

import com.challenge.model.Character;

import java.util.Random;

import static com.challenge.engine.utils.FileUtils.waitSeconds;

public class AnswerBossMomAction implements FightAction {

    @Override
    public void executeAction(Character character) {
        final Random random = new Random();
        final int problems = random.nextInt(10) + 1;
        System.out.println("Your boss mom is very cute!");
        waitSeconds(2);
        System.out.println("She brought coffees and problems");
        waitSeconds(1);
        System.out.println(".....");
        waitSeconds(2);
        System.out.println("You have to solve " + problems + " nice bugs");
        waitSeconds(3);
        System.out.println("DOUBLE COFFEE for each corrected bug!");
        final int solvedProblems = random.nextInt(problems);
        final int coffeesWon = solvedProblems  * 2;
        final int damage = problems - solvedProblems;
        System.out.println("OH, MOMMY! You have fixed " + solvedProblems + " that gives you " + coffeesWon + " coffees!");
        waitSeconds(3);
        System.out.println("But you lost " + damage + " caffeine cells from your body.");
        character.drinkCoffee(coffeesWon);
        character.receiveDamage(damage);
        waitSeconds(2);
    }

}