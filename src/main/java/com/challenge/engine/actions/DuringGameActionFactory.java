package com.challenge.engine.actions;

import com.challenge.engine.fight.FightActionFactory;
import com.challenge.engine.utils.FileUtils;

import java.util.*;

public class DuringGameActionFactory {

    private final Map<Integer, DuringGameAction> duringGameActionMap = new HashMap<>();

    public DuringGameActionFactory(final FileUtils fileUtils, final Random random,
                                   final FightActionFactory fightActionFactory) {
        duringGameActionMap.put(1, new ReadNextMessageAction(random, fightActionFactory));
        duringGameActionMap.put(2, new SaveGameAndExitAction(fileUtils));
        duringGameActionMap.put(3, new AbandonGameAction());
    }

    public DuringGameAction findDuringGameAction(final Integer commandId) {
        if(Objects.isNull(commandId) || commandId < 0 || !duringGameActionMap.keySet().contains(commandId)) {
            throw new IllegalArgumentException();
        }

        return duringGameActionMap.get(commandId);
    }

    public Collection<Integer> getAvailableOptions() {
        return duringGameActionMap.keySet();
    }

}