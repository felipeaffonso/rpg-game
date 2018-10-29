package com.challenge.engine.fight;

import com.challenge.engine.utils.FileUtils;
import com.challenge.model.Character;

import java.util.Random;


public class GoCoffeeShopAction implements FightAction {

    private final FileUtils fileUtils;

    private final Random random;

    GoCoffeeShopAction(final FileUtils fileUtils, final Random random) {
        this.fileUtils = fileUtils;
        this.random = random;
    }

    @Override
    public void executeAction(final Character character) {
        final Integer coffees = this.random.nextInt(5) + 1;
        System.out.println("You are now at the coffee shop");
        this.fileUtils.waitSeconds(2);
        System.out.println("Enjoy your coffee...");
        this.fileUtils.waitSeconds(2);
        System.out.println("Go get a REAL COFFEE!");
        this.fileUtils.waitSeconds(2);
        System.out.println("Yeah!!! Nice! " + coffees + " more coffee cells are now giving you so much pleasure!");
        this.fileUtils.waitSeconds(2);
        character.drinkCoffee(coffees);
    }
}
