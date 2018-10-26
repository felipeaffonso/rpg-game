package com.challenge.engine;

import java.util.Objects;

public class GameActionExecutor {

    public int executeOperation(final GameAction gameAction) throws UnsupportedOperationException {
//        if(Objects.nonNull(gameAction)) {
//            return gameAction.execute();
//        }
        throw new UnsupportedOperationException("Invalid GameAction");
    }

}