package com.challenge;

import com.challenge.engine.GameEngine;
import com.challenge.engine.GameFinisher;
import com.challenge.engine.GameLoader;
import com.challenge.engine.GamePlayer;
import com.challenge.exception.EndGameException;

public class RpgGame {

    private static final GameEngine gameEngine = new GameEngine(new GameFinisher(), new GameLoader(), new GamePlayer());

    public static void main(String[] args) {
        try {
            gameEngine.startGame();
        } catch (final EndGameException egx) {
            System.err.println(egx.getMessage());
        }

    }
}
