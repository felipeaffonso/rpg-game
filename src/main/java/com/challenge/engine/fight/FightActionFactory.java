package com.challenge.engine.fight;

import com.challenge.engine.utils.FileUtils;

import java.util.*;

public class FightActionFactory {

    private final Map<Integer, FightAction> fightActionMpa = new HashMap<>();

    public FightActionFactory(final FileUtils fileUtils, final Random random) {
        fightActionMpa.put(0, new GoCoffeeShopAction(fileUtils, random));
        fightActionMpa.put(1, new FindMonsterBugAction(fileUtils, random));
        fightActionMpa.put(2, new AnswerBossMomAction(fileUtils, random));
        fightActionMpa.put(3, new FindDisturbingPersonAtPrinter(fileUtils, random));
    }

    public FightAction findFightAction(final Integer commandId) {
        if(Objects.isNull(commandId) || commandId < 0 || !fightActionMpa.keySet().contains(commandId)) {
            throw new IllegalArgumentException();
        }

        return fightActionMpa.get(commandId);
    }

    public Collection<Integer> getAvailableOptions() {
        return fightActionMpa.keySet();
    }
}
