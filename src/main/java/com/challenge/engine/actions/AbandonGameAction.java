package com.challenge.engine.actions;

import com.challenge.exception.EndGameException;
import com.challenge.model.Character;

public class AbandonGameAction implements DuringGameAction {
    @Override
    public void executeAction(Character character) {
        throw new EndGameException("The Game was Finished. All your current progress now it is in another dimension");
    }
}
