package com.challenge.engine.menu;

import com.challenge.engine.utils.FileUtils;
import com.challenge.exception.EndGameException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class FinishGameCommandTest {

    @Mock
    private FileUtils fileUtils;

    @InjectMocks
    private FinishGameCommand target;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void execute() {
        final String expectedMessage = "Maybe you could try my game another time! Thanks!";
        Mockito.when(this.fileUtils.getString(anyString())).thenReturn(expectedMessage);
        thrown.expect(EndGameException.class);
        thrown.expectMessage(expectedMessage);

        this.target.execute();
    }
}