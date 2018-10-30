package com.challenge.engine.fight;

import com.challenge.engine.utils.FileUtils;
import com.challenge.model.Character;

import java.text.MessageFormat;
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
        System.out.println(this.fileUtils.getString("action.shop.welcome"));
        this.fileUtils.waitSeconds(2);
        this.printMug();
        this.fileUtils.waitSeconds(2);
        System.out.println(this.fileUtils.getString("action.shop.enjoy"));
        this.fileUtils.waitSeconds(2);
        System.out.println(this.fileUtils.getString("action.shop.real"));
        this.fileUtils.waitSeconds(2);
        System.out.println(MessageFormat.format(this.fileUtils.getString("action.shop.coffees"), coffees));
        this.fileUtils.waitSeconds(2);
        character.drinkCoffee(coffees);
    }

    private void printMug() {
        System.out.println(
                "      )  (\n" +
                "     (   ) )\n" +
                "      ) ( (\n" +
                "    (______)_\n" +
                " .-'---------|  \n" +
                "( C|/\\/\\/\\/\\/|\n" +
                " '-./\\/\\/\\/\\/|\n" +
                "   '_________'\n" +
                "    '-------'");
    }

}
