package com.challenge.engine.menu;

import com.challenge.engine.utils.FileUtils;
import com.challenge.engine.utils.InputUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MenuActionFactory {

    private final Map<Integer, MenuAction> gameActionMap = new HashMap<>();

    public MenuActionFactory(final FileUtils fileUtils, final InputUtils inputUtils) {
        gameActionMap.put(1, new NewGameCommand(inputUtils, fileUtils));
        gameActionMap.put(2, new LoadGameCommand(inputUtils, fileUtils));
        gameActionMap.put(3, new FinishGameCommand(fileUtils));
    }

    public MenuAction findMenuAction(final Integer commandId) {
        if(Objects.isNull(commandId) || commandId < 0 || !gameActionMap.keySet().contains(commandId)) {
            throw new IllegalArgumentException();
        }

        return gameActionMap.get(commandId);
    }

    public Collection<Integer> getAvailableOptions() {
        return this.gameActionMap.keySet();
    }

}