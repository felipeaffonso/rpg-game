package com.challenge.engine.actions;

import com.challenge.engine.utils.FileUtils;
import com.challenge.exception.EndGameException;
import com.challenge.model.Character;

public class SaveGameAndExitAction implements DuringGameAction {
    @Override
    public void executeAction(Character character) {
        try {
            final String uuid = FileUtils.saveCharacterToFile(character);
            throw new EndGameException("WoW! Your progress is awesome!!! " +
                    "Here is your password to restore it next time:" + uuid);
        } catch(final EndGameException egx) {
            throw egx;
        } catch(final Exception e) {
            throw new EndGameException("Error trying to save your progress, sorry :-(");
        }
    }
}
