package com.challenge;

import com.challenge.engine.utils.FileUtils;

public class RpgGame {

    private static final FileUtils fileUtils = new FileUtils();

    protected RpgGame() {
        super();
    }

    public static void main(String[] args) {
        printWelcomeMessage();
        try {
            new GameApplication()
                    .setup(fileUtils)
                    .startGameMenu();
        } catch (final Exception egx) {
            System.err.println(egx.getMessage());
        } finally {
            System.exit(-1);
        }
    }

    private static void printWelcomeMessage() {
        printTitle();
        fileUtils.waitSeconds(2);
        printCoffee();
        fileUtils.waitSeconds(2);
        System.out.println(fileUtils.getString("game.intro"));
        fileUtils.waitSeconds(2);
    }

    private static void printCoffee() {
        System.out.println(
                        "                  ., '''''''''''''''''' ,.\n" +
                        "               .'   .oooooo$$$$$ooooooo.   '.\n" +
                        "              ::  ,$$$$$$$$$$$$$$$$$$$$$$,  ',\n" +
                        "              |;  '$$$$$$$$$$$$$$$$$$$$$$'    ''''''''''.\n" +
                        "              |;     ''''''$$$$$'''''''       ,:''''':, |\n" +
                        "              |;   '|                   |'    ||      | |\n" +
                        "              |;   '|                   |'    ||      | |\n" +
                        "              |;   '|                   |'    ||      | |\n" +
                        "              |;   '|                   |'    ||      | |\n" +
                        "              |;   '|                   |'    ':.....:' |\n" +
                        "              |;   '|                   |'     ,,,,,,,,,'\n" +
                        "              |;   '|                   |'    ;\n" +
                        "              |;.   |                   |   .'\n" +
                        "               '||,,,                   ,,,;'\n" +
                        "                  ''';;;;,,,,,,,,,,,;;;;'''\n" +
                        "                         '''''''''''"
                );
    }

    private static void printTitle() {
        System.out.println("\n" +
                "▄▄▄█████▓ ██░ ██ ▓█████     ▄████▄   ▒█████    █████▒ █████▒▓█████ ▓█████     ▄▄▄██▀▀▀▒█████   █    ██  ██▀███   ███▄    █ ▓█████▓██   ██▓\n" +
                "▓  ██▒ ▓▒▓██░ ██▒▓█   ▀    ▒██▀ ▀█  ▒██▒  ██▒▓██   ▒▓██   ▒ ▓█   ▀ ▓█   ▀       ▒██  ▒██▒  ██▒ ██  ▓██▒▓██ ▒ ██▒ ██ ▀█   █ ▓█   ▀ ▒██  ██▒\n" +
                "▒ ▓██░ ▒░▒██▀▀██░▒███      ▒▓█    ▄ ▒██░  ██▒▒████ ░▒████ ░ ▒███   ▒███         ░██  ▒██░  ██▒▓██  ▒██░▓██ ░▄█ ▒▓██  ▀█ ██▒▒███    ▒██ ██░\n" +
                "░ ▓██▓ ░ ░▓█ ░██ ▒▓█  ▄    ▒▓▓▄ ▄██▒▒██   ██░░▓█▒  ░░▓█▒  ░ ▒▓█  ▄ ▒▓█  ▄    ▓██▄██▓ ▒██   ██░▓▓█  ░██░▒██▀▀█▄  ▓██▒  ▐▌██▒▒▓█  ▄  ░ ▐██▓░\n" +
                "  ▒██▒ ░ ░▓█▒░██▓░▒████▒   ▒ ▓███▀ ░░ ████▓▒░░▒█░   ░▒█░    ░▒████▒░▒████▒    ▓███▒  ░ ████▓▒░▒▒█████▓ ░██▓ ▒██▒▒██░   ▓██░░▒████▒ ░ ██▒▓░\n" +
                "  ▒ ░░    ▒ ░░▒░▒░░ ▒░ ░   ░ ░▒ ▒  ░░ ▒░▒░▒░  ▒ ░    ▒ ░    ░░ ▒░ ░░░ ▒░ ░    ▒▓▒▒░  ░ ▒░▒░▒░ ░▒▓▒ ▒ ▒ ░ ▒▓ ░▒▓░░ ▒░   ▒ ▒ ░░ ▒░ ░  ██▒▒▒ \n" +
                "    ░     ▒ ░▒░ ░ ░ ░  ░     ░  ▒     ░ ▒ ▒░  ░      ░       ░ ░  ░ ░ ░  ░    ▒ ░▒░    ░ ▒ ▒░ ░░▒░ ░ ░   ░▒ ░ ▒░░ ░░   ░ ▒░ ░ ░  ░▓██ ░▒░ \n" +
                "  ░       ░  ░░ ░   ░      ░        ░ ░ ░ ▒   ░ ░    ░ ░       ░      ░       ░ ░ ░  ░ ░ ░ ▒   ░░░ ░ ░   ░░   ░    ░   ░ ░    ░   ▒ ▒ ░░  \n" +
                "          ░  ░  ░   ░  ░   ░ ░          ░ ░                    ░  ░   ░  ░    ░   ░      ░ ░     ░        ░              ░    ░  ░░ ░     \n" +
                "                           ░                                                                                                      ░ ░     \n");
    }
}
