package com.challenge.engine.actions;

import com.challenge.engine.utils.FileUtils;
import com.challenge.exception.EndGameException;
import com.challenge.model.Character;

public class SaveGameAndExitAction implements DuringGameAction {

    private final FileUtils fileUtils;

    public SaveGameAndExitAction(final FileUtils fileUtils) {
        this.fileUtils = fileUtils;
    }

    @Override
    public void executeAction(Character character) {
        try {
            final String uuid = fileUtils.saveCharacterToFile(character);
            throw new EndGameException(this.fileUtils.getString("game.showPassword") + uuid);
        } catch(final EndGameException egx) {
            throw egx;
        } catch(final Exception e) {
            throw new EndGameException("Error trying to save your progress, sorry :-(");
        }
    }
}
