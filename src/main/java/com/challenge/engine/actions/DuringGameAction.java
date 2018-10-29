package com.challenge.engine.actions;

import com.challenge.model.Character;

@FunctionalInterface
public interface DuringGameAction {

    void executeAction(Character character);

}