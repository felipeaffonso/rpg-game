package com.challenge.engine.fight;

import com.challenge.engine.utils.FileUtils;
import com.challenge.model.Character;

import java.util.Random;

import static java.text.MessageFormat.format;

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
        printMom();
        System.out.println(this.fileUtils.getString("action.mom.cute"));
        this.fileUtils.waitSeconds(2);
        System.out.println(this.fileUtils.getString("action.mom.brought"));
        this.fileUtils.waitSeconds(1);
        System.out.println(this.fileUtils.getString("action.mom.points"));
        this.fileUtils.waitSeconds(2);
        System.out.println(format(this.fileUtils.getString("action.mom.solve"), problems));
        this.fileUtils.waitSeconds(3);
        System.out.println(this.fileUtils.getString("action.mom.double"));
        final int solvedProblems = this.random.nextInt(problems);
        final int coffeesWon = solvedProblems * 2;
        final int damage = problems - solvedProblems;
        System.out.println(format(this.fileUtils.getString("action.mom.fixed"), solvedProblems, coffeesWon));
        this.fileUtils.waitSeconds(3);
        System.out.println(format(this.fileUtils.getString("action.mom.lost"), damage));
        character.drinkCoffee(coffeesWon);
        character.receiveDamage(damage);
        this.fileUtils.waitSeconds(2);
    }

    private void printMom() {
        System.out.println(
                " /////////////\\\\\\\\\n" +
                "(((((((((((((( \\\\\\\\\n" +
                "))) ~~      ~~  (((\n" +
                "((( (*)     (*) )))\n" +
                ")))     <       (((\n" +
                "((( '\\______/`  )))\n" +
                ")))\\___________/(((\n" +
                "       _) (_\n" +
                "      / \\_/ \\\n" +
                "     /(     )\\\n" +
                "    // )___( \\\\\n" +
                "    \\\\(     )//\n" +
                "     (       )\n" +
                "      |  |  |\n" +
                "       | | |\n" +
                "       | | |\n" +
                "      _|_|_|_");
    }

}