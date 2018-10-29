package com.challenge.engine.fight;

import com.challenge.engine.utils.FileUtils;
import com.challenge.model.Character;

import java.util.Random;


public class FindDisturbingPersonAtPrinter  implements FightAction {

    private final FileUtils fileUtils;
    private final Random random;

    public FindDisturbingPersonAtPrinter(final FileUtils fileUtils, final Random random) {
        this.fileUtils = fileUtils;
        this.random = random;
    }

    @Override
    public void executeAction(Character character) {
        final int damage = this.random.nextInt(5) + 1;
        System.out.println("Hi...");
        this.fileUtils.waitSeconds(2);
        System.out.println("How are you?");
        this.fileUtils.waitSeconds(2);
        System.out.println(".....");
        this.fileUtils.waitSeconds(2);
        System.out.println("Would you like to be my friend on Facebook?");
        this.fileUtils.waitSeconds(2);
        System.out.println("Ahhhhhh.... that is enough!");
        this.fileUtils.waitSeconds(1);
        System.out.println("Just pay " + damage + " coffee cells and come back to your desk!");
        character.receiveDamage(damage);
        this.fileUtils.waitSeconds(2);
    }
}
