package com.challenge.engine.actions;

import com.challenge.engine.utils.FileUtils;
import com.challenge.exception.EndGameException;
import com.challenge.model.Character;
import com.challenge.model.CharacterClassEnum;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SaveGameAndExitActionTest {

    @Mock
    private FileUtils fileUtils;

    @InjectMocks
    private SaveGameAndExitAction target;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Character character;

    @Before
    public void setUp() {
        this.character = new Character("ANOTHER DUMMY", CharacterClassEnum.PYTHON_PROGRAMMER);
    }

    @Test
    public void executeActionMustReturnEndGameExceptionWithMessageAndPassword() {
        final String uuid = UUID.randomUUID().toString();
        final String expectedMessage = "WoW! Your progress is awesome!!! " +
                "Here is your password to restore it next time:" + uuid;

        when(this.fileUtils.saveCharacterToFile(this.character)).thenReturn(uuid);

        thrown.expect(EndGameException.class);
        thrown.expectMessage(expectedMessage);

        target.executeAction(character);
    }

    @Test
    public void executeActionMustReturnEndGameExceptionWithSorryMessage() {
        final String expectedMessage = "Error trying to save your progress, sorry :-(";

        final Exception exception = new NullPointerException("Could not save");

        when(this.fileUtils.saveCharacterToFile(this.character)).thenThrow(exception);

        thrown.expect(EndGameException.class);
        thrown.expectMessage(expectedMessage);

        target.executeAction(character);
    }
}