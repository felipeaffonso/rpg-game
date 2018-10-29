package com.challenge;

import com.challenge.engine.GameEngine;
import com.challenge.engine.actions.DuringGameActionFactory;
import com.challenge.engine.fight.FightActionFactory;
import com.challenge.engine.menu.MainMenu;
import com.challenge.engine.menu.MenuActionFactory;
import com.challenge.engine.utils.FileUtils;
import com.challenge.engine.utils.InputUtils;

import java.util.Random;
import java.util.Scanner;

public class GameApplication {

    public MainMenu setup() {
        final FileUtils fileUtils = new FileUtils();
        final InputUtils inputUtils = new InputUtils(new Scanner(System.in));
        final Random random = new Random();
        final MenuActionFactory menuActionFactory = new MenuActionFactory(fileUtils, inputUtils);
        final FightActionFactory fightActionFactory = new FightActionFactory(fileUtils, random);
        final DuringGameActionFactory duringGameActionFactory = new DuringGameActionFactory(fileUtils, random, fightActionFactory);
        final GameEngine gameEngine = new GameEngine(duringGameActionFactory, inputUtils);

        return new MainMenu(menuActionFactory, gameEngine, inputUtils);
    }
}
