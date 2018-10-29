package com.challenge;

public class RpgGame {

    protected RpgGame() {
        super();
    }

    public static void main(String[] args) {
        printWelcomeMessage();
        try {
            new GameApplication()
                    .setup()
                    .startGameMenu();
        } catch (final Exception egx) {
            System.err.println(egx.getMessage());
        } finally {
            System.exit(-1);
        }
    }

    private static void printWelcomeMessage() {
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

        System.out.println(
                "At this game, you are a Software Developer that is trying to do what we do every day: Drink Coffee!\n" +
                "\n" +
                "You can choose your Programming Language, but you have to think with your brain, not with your heart S2!\n" +
                "\n" +
                "Here is the dynamics:\n" +
                "\n" +
                "You are now at your desk with Slack window opened and with a lot of notifications blinking!\n" +
                "\n" +
                "Each slack message could have a good or bad surprise, that guides you in our path to **Coffee Nirvana**, when you everything become shiny and clear (this is the end of the game).\n" +
                "\n" +
                "But... I don't think only good thinks are going to happen! You will need to correct a lot of bugs and solve a lot of problems too.\n" +
                "\n" +
                "If your caffeine level reach ZERO, then you are DEAD\n" +
                "\n" +
                "I wish you good luck!");
    }
}
