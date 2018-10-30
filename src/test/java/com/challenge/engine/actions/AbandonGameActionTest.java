package com.challenge.engine.actions;

import com.challenge.engine.utils.FileUtils;
import com.challenge.exception.EndGameException;
import com.challenge.model.Character;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AbandonGameActionTest {

    @Mock
    private FileUtils fileUtils;

    @InjectMocks
    private AbandonGameAction target;

    @Test(expected = EndGameException.class)
    public void executeAction() {
        final Character character = null;
        target.executeAction(character);
    }
}