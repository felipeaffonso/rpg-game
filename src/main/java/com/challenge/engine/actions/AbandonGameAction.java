package com.challenge.engine.actions;

import com.challenge.engine.utils.FileUtils;
import com.challenge.exception.EndGameException;
import com.challenge.model.Character;

public class AbandonGameAction implements DuringGameAction {

    private final FileUtils fileUtils;

    AbandonGameAction(final FileUtils fileUtils) {
        this.fileUtils = fileUtils;
    }

    @Override
    public void executeAction(Character character) {
        final String message = this.fileUtils.getString("game.action.abandon");
        throw new EndGameException(message);
    }
}
