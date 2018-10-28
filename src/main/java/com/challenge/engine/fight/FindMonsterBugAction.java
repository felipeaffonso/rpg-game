package com.challenge.engine.fight;

import com.challenge.model.Character;

import java.util.Random;

import static com.challenge.engine.utils.FileUtils.waitSeconds;

public class FindMonsterBugAction implements FightAction {


    @Override
    public void executeAction(final Character character) {

        final Random random = new Random();
        final int bugsQuantity = random.nextInt(15) + 1;
        System.out.println("The monster bug is now in front of you.");
        waitSeconds(2);
        System.out.println("This crazy thing is procreating! :<");
        waitSeconds(1);
        System.out.println(".....");
        waitSeconds(2);
        System.out.println("Now they are " + bugsQuantity + " little and disgusting bugs.");
        waitSeconds(2);
        System.out.println("Correcting them...");
        waitSeconds(3);
        final int correctedBugs = random.nextInt(bugsQuantity);
        final int coffeesWon = correctedBugs * character.getClazz().getLanguageDamage();
        final int damage = bugsQuantity - correctedBugs;
        System.out.println("Time is up! You have fixed " + correctedBugs + " that gives you " + coffeesWon + " coffees!");
        waitSeconds(3);
        System.out.println("But you lost " + damage + " caffeine cells from your body.");
        character.drinkCoffee(coffeesWon);
        character.receiveDamage(damage);
        waitSeconds(2);
    }

}
