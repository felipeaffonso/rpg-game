package com.challenge.engine.fight;

import com.challenge.model.Character;

import java.util.Random;

import static com.challenge.engine.utils.FileUtils.waitSeconds;

public class GoCoffeeShopAction implements FightAction {

    @Override
    public void executeAction(final Character character) {
        final Random random = new Random();
        final Integer coffees = random.nextInt(5) + 1;
        System.out.println("You are now at the coffee shop");
        waitSeconds(2);
        System.out.println("Enjoy your coffee...");
        waitSeconds(2);
        System.out.println("Go get a REAL COFFEE!");
        waitSeconds(2);
        System.out.println("Yeah!!! Nice! " + coffees + " more coffee cells are now giving you so much pleasure!");
        waitSeconds(2);
        character.drinkCoffee(coffees);
    }
}
