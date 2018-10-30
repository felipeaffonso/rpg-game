package com.challenge.engine;

import com.challenge.engine.actions.AbandonGameAction;
import com.challenge.engine.actions.DuringGameActionFactory;
import com.challenge.engine.actions.ReadNextMessageAction;
import com.challenge.engine.utils.FileUtils;
import com.challenge.engine.utils.InputUtils;
import com.challenge.exception.EndGameException;
import com.challenge.exception.InvalidOptionException;
import com.challenge.model.Character;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.challenge.model.CharacterClassEnum.JAVASCRIPT_PROGRAMMER;
import static java.util.Arrays.asList;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameEngineTest {

    private static final String THIS_IS_THE_END = "This is the end...";

    @Mock
    private DuringGameActionFactory duringGameActionFactory;

    @Mock
    private InputUtils inputUtils;

    @Mock
    private FileUtils fileUtils;

    @Mock
    private ReadNextMessageAction readNextMessageAction;

    @Mock
    private AbandonGameAction abandonGameAction;

    @InjectMocks
    private GameEngine target;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Character character;

    @Before
    public void setUp() {
        this.character = new Character("Game Engine Char", JAVASCRIPT_PROGRAMMER);
    }

    @Test
    public void startGameHandlingPossibleErrors() {
        final List<Integer> availableOptions = asList(1, 2, 3);

        doReturn(availableOptions).when(this.duringGameActionFactory).getAvailableOptions();

        final Exception invalidOptionException = new InvalidOptionException();
        final int readNextMessageCommand = 1;
        final int abandonGameMessageCommand = 3;

        doThrow(invalidOptionException)
                .doReturn(readNextMessageCommand)
                .doReturn(abandonGameMessageCommand)
                .when(this.inputUtils).validateIntegerInput(availableOptions);

        doReturn(readNextMessageAction)
                .doReturn(abandonGameAction)
                .when(this.duringGameActionFactory).findDuringGameAction(anyInt());

        final Exception endGameException = new EndGameException(THIS_IS_THE_END);

        doNothing().when(this.readNextMessageAction).executeAction(this.character);
        doThrow(endGameException).when(this.abandonGameAction).executeAction(this.character);

        doReturn("Message").when(this.fileUtils).getString(anyString());

        thrown.expect(EndGameException.class);
        thrown.expectMessage(THIS_IS_THE_END);

        this.target.startGame(this.character);
    }
}