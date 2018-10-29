package com.challenge.engine.fight;

import com.challenge.model.Character;

@FunctionalInterface
public interface FightAction {

    void executeAction(Character character);

}