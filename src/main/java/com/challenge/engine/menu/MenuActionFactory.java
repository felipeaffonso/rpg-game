package com.challenge.engine.menu;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MenuActionFactory {

    private final Map<Integer, MenuAction> gameActionMap = new HashMap<>();

    public MenuActionFactory() {
        gameActionMap.put(1, new NewGameCommand());
        gameActionMap.put(2, new LoadGameCommand());
        gameActionMap.put(3, new FinishGameCommand());
    }

    public MenuAction findMenuAction(final Integer commandId) {
        assert Objects.nonNull(commandId) && commandId >= 0 && gameActionMap.keySet().contains(commandId);

        return gameActionMap.get(commandId);
    }

    public Collection<Integer> getAvailableOptions() {
        return this.gameActionMap.keySet();
    }

}