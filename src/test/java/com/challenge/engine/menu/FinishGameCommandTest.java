package com.challenge.engine.menu;

import com.challenge.exception.EndGameException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FinishGameCommandTest {

    @InjectMocks
    private FinishGameCommand target;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void execute() {
        thrown.expect(EndGameException.class);
        thrown.expectMessage("Maybe you could try my game another time! Thanks!");

        this.target.execute();
    }
}