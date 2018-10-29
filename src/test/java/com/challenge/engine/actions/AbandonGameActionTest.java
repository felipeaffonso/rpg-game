package com.challenge.engine.actions;

import com.challenge.exception.EndGameException;
import com.challenge.model.Character;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AbandonGameActionTest {

    @InjectMocks
    private AbandonGameAction target;

    @Test(expected = EndGameException.class)
    public void executeAction() {
        final Character character = null;
        target.executeAction(character);
    }
}