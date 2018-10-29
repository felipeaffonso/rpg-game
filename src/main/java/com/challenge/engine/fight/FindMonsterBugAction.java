package com.challenge.engine.fight;

import com.challenge.engine.utils.FileUtils;
import com.challenge.model.Character;

import java.util.Random;

public class FindMonsterBugAction implements FightAction {

    private final FileUtils fileUtils;

    private final Random random;

    public FindMonsterBugAction(final FileUtils fileUtils, final Random random) {
        this.fileUtils = fileUtils;
        this.random = random;
    }

    @Override
    public void executeAction(final Character character) {
        final int bugsQuantity = this.random.nextInt(15) + 1;
        System.out.println("The monster bug is now in front of you.");
        this.fileUtils.waitSeconds(2);
        System.out.println("This crazy thing is procreating! :<");
        this.fileUtils.waitSeconds(1);
        System.out.println(".....");
        this.fileUtils.waitSeconds(2);
        System.out.println("Now they are " + bugsQuantity + " little and disgusting bugs.");
        this.fileUtils.waitSeconds(2);
        System.out.println("Correcting them...");
        this.fileUtils.waitSeconds(3);
        final int correctedBugs = this.random.nextInt(bugsQuantity);
        final int coffeesWon = correctedBugs * character.getClazz().getLanguageDamage();
        final int damage = bugsQuantity - correctedBugs;
        System.out.println("Time is up! You have fixed " + correctedBugs + " that gives you " + coffeesWon + " coffees!");
        this.fileUtils.waitSeconds(3);
        System.out.println("But you lost " + damage + " caffeine cells from your body.");
        character.drinkCoffee(coffeesWon);
        character.receiveDamage(damage);
        this.fileUtils.waitSeconds(2);
    }

}
