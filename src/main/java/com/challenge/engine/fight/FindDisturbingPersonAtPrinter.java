package com.challenge.engine.fight;

import com.challenge.engine.utils.FileUtils;
import com.challenge.model.Character;

import java.text.MessageFormat;
import java.util.Random;

import static java.text.MessageFormat.format;


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
        System.out.println(this.fileUtils.getString("action.printer.hi"));
        this.fileUtils.waitSeconds(2);
        printPrinter();
        System.out.println(this.fileUtils.getString("action.printer.hello"));
        this.fileUtils.waitSeconds(2);
        System.out.println(".....");
        this.fileUtils.waitSeconds(2);
        System.out.println(this.fileUtils.getString("action.printer.face"));
        this.fileUtils.waitSeconds(2);
        System.out.println(this.fileUtils.getString("action.printer.enough"));
        this.fileUtils.waitSeconds(1);
        System.out.println(format(this.fileUtils.getString("action.printer.pay"), damage));
        character.receiveDamage(damage);
        this.fileUtils.waitSeconds(2);
    }

    private void printPrinter() {
        System.out.println(
                "    ______________\n" +
                "   /             /|\n" +
                "  /             / |\n" +
                " /____________ /  |\n" +
                "|  _________  |   |____________________\n" +
                "| |         | |   |/        /|,       /|\n" +
                "| |     ..  | |   /        / /9      / |\n" +
                "| |  .      | |  /_______ / /9      /  |\n" +
                "| |_________| | |  ____ +| /9      /   |\n" +
                "|________++___|/|________|/9      /    |\n" +
                "   ________________     ,9`      /   / |\n" +
                "  /  -/      /-   /|  ,9        /   /| |\n" +
                " /______________ //|,9         /   / | |\n" +
                "|       ______  ||,9          /   /  | |\n" +
                "|  -+  |_9366_| ||/          /   /|  | |\n" +
                "|_______________|/__________/   / |  | |\n" +
                "/////----------/|           |  /__|  | |___\n" +
                "|o     o  \\o|  \\|           |  |  |  | |\n" +
                "|o    \\|_  ||  o|______     |  |__|  | |_____\n" +
                "|o \\_  |   ||  o|      |    |  |  |  | /\n" +
                "|o /   |\\  /|  o|      |    |  |  |__|/\n" +
                "|o             o|      |    |  |\n" +
                "|o-------------o|      |    |  |\n" +
                "|o   /\\/\\      o|      |    |  |\n" +
                "|o  / o o|     o|      |    |  |\n" +
                "|o / \\_+_/     o|      |    |  |\n" +
                "|o |\\     \\    o|      |    |  |\n" +
                "|o | |+ +-|    o|      |    |  |\n" +
                "|o-------------o|      |    |  |\n" +
                "|o     /|      o|      |    | / \n" +
                " \\/|/|/ |/\\/|/\\/       |____|/");
    }
}
