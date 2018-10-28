package com.challenge.engine.fight;

import com.challenge.model.Character;

import java.util.Random;

import static com.challenge.engine.utils.FileUtils.waitSeconds;

public class FindDisturbingPersonAtPrinter  implements FightAction {

    @Override
    public void executeAction(Character character) {
        final Random random = new Random();
        final int damage = random.nextInt(5) + 1;
        System.out.println("Hi...");
        waitSeconds(2);
        System.out.println("How are you?");
        waitSeconds(2);
        System.out.println(".....");
        waitSeconds(2);
        System.out.println("Would you like to be my friend on Facebook?");
        waitSeconds(2);
        System.out.println("Ahhhhhh.... that is enough!");
        waitSeconds(1);
        System.out.println("Just pay " + damage + " coffee cells and come back to your desk!");
        character.receiveDamage(damage);
        waitSeconds(2);
    }
}
