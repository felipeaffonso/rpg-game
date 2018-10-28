package com.challenge.engine.menu;

import com.challenge.exception.EndGameException;
import com.challenge.model.Character;

public class FinishGameCommand implements MenuAction {

    @Override
    public Character execute() {
        throw new EndGameException("Maybe you could try my game another time! Thanks!");
    }

}