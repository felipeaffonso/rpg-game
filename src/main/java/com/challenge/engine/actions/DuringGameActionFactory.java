package com.challenge.engine.actions;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DuringGameActionFactory {

    private static final Map<Integer, DuringGameAction> duringGameActionMap = new HashMap<>();
    static {
        duringGameActionMap.put(1, new ReadNextMessageAction());
        duringGameActionMap.put(2, new SaveGameAndExitAction());
        duringGameActionMap.put(3, new AbandonGameAction());
    }

    public DuringGameAction findDuringGameAction(final Integer commandId) {
        assert Objects.nonNull(commandId) && commandId >= 0 && duringGameActionMap.keySet().contains(commandId);

        return duringGameActionMap.get(commandId);
    }

    public Collection<Integer> getAvailableOptions() {
        return duringGameActionMap.keySet();
    }

}