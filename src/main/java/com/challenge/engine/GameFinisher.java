package com.challenge.engine;

public class GameFinisher implements GameAction{
    @Override
    public boolean execute() {
        System.out.println("Thanks for Playing! See you later");
        return false;
    }
}
