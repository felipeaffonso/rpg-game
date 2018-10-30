package com.challenge.engine.menu;

import com.challenge.engine.utils.FileUtils;
import com.challenge.exception.EndGameException;
import com.challenge.model.Character;

public class FinishGameCommand implements MenuAction {

    private final FileUtils fileUtils;

    FinishGameCommand(final FileUtils fileUtils) {
        this.fileUtils = fileUtils;
    }

    @Override
    public Character execute() {
        final String message = this.fileUtils.getString("game.action.finish");
        throw new EndGameException(message);
    }

}