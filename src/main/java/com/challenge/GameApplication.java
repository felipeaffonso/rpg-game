package com.challenge;

import com.challenge.engine.GameEngine;
import com.challenge.engine.actions.DuringGameActionFactory;
import com.challenge.engine.menu.MainMenu;
import com.challenge.engine.menu.MenuActionFactory;


public class GameApplication {

    public MainMenu setup() {
        final MenuActionFactory menuActionFactory = new MenuActionFactory();
        final DuringGameActionFactory duringGameActionFactory = new DuringGameActionFactory();
        final GameEngine gameEngine = new GameEngine(duringGameActionFactory);

        return new MainMenu(menuActionFactory, duringGameActionFactory, gameEngine);
    }
}
