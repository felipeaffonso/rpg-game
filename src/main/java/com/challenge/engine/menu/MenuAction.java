package com.challenge.engine.menu;

import com.challenge.model.Character;

@FunctionalInterface
public interface MenuAction {

    Character execute();

}