package com.challenge.engine.fight;

import com.challenge.engine.utils.FileUtils;
import com.challenge.model.Character;

import java.text.MessageFormat;
import java.util.Random;

import static java.text.MessageFormat.format;

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
        System.out.println(this.fileUtils.getString("action.monster.welcome"));
        this.fileUtils.waitSeconds(2);
        printMonster();
        this.fileUtils.waitSeconds(2);
        System.out.println(this.fileUtils.getString("action.monster.crazy"));
        this.fileUtils.waitSeconds(1);
        this.fileUtils.waitSeconds(2);
        System.out.println(format(this.fileUtils.getString("action.monster.little"), bugsQuantity));
        this.fileUtils.waitSeconds(2);
        System.out.println(this.fileUtils.getString("action.monster.correcting"));
        this.fileUtils.waitSeconds(3);
        final int correctedBugs = this.random.nextInt(bugsQuantity);
        final int coffeesWon = correctedBugs * character.getClazz().getLanguageDamage();
        final int damage = bugsQuantity - correctedBugs;
        System.out.println(format(this.fileUtils.getString("action.monster.time"), correctedBugs, coffeesWon));
        this.fileUtils.waitSeconds(3);
        System.out.println(format(this.fileUtils.getString("action.monster.lost"), damage));
        character.drinkCoffee(coffeesWon);
        character.receiveDamage(damage);
        this.fileUtils.waitSeconds(2);
    }

    private void printMonster() {
        System.out.println(
                "            _.------.                        .----.__\n" +
                "           /         \\_.       ._           /---.__  \\\n" +
                "          |  O    O   |\\\\___  //|          /       `\\ |\n" +
                "          |  .vvvvv.  | )   `(/ |         | o     o  \\|\n" +
                "          /  |     |  |/      \\ |  /|   ./| .vvvvv.  |\\\n" +
                "         /   `^^^^^'  / _   _  `|_ ||  / /| |     |  | \\\n" +
                "       ./  /|         | O)  O   ) \\|| //' | `^vvvv'  |/\\\\\n" +
                "      /   / |         \\        /  | | ~   \\          |  \\\\\n" +
                "      \\  /  |        / \\ Y   /'   | \\     |          |   ~\n" +
                "       `'   |  _     |  `._/' |   |  \\     7        /\n" +
                "         _.-'-' `-'-'|  |`-._/   /    \\ _ /    .    |\n" +
                "    __.-'            \\  \\   .   / \\_.  \\ -|_/\\/ `--.|_\n" +
                " --'                  \\  \\ |   /    |  |              `-\n" +
                "                       \\uU \\UU/     |  /   ");
    }

}
