package com.challenge.engine.menu;

import com.challenge.engine.utils.FileUtils;
import com.challenge.engine.utils.InputUtils;
import com.challenge.exception.InvalidOptionException;
import com.challenge.model.Character;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static com.challenge.model.CharacterClassEnum.PYTHON_PROGRAMMER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoadGameCommandTest {

    @Mock
    private InputUtils inputUtils;

    @Mock
    private FileUtils fileUtils;

    @InjectMocks
    private LoadGameCommand target;

    private Character character;

    @Before
    public void setUp() {
        this.character = new Character("Dummy Again", PYTHON_PROGRAMMER);
    }

    @Test
    public void execute() {
        final String password = UUID.randomUUID().toString();
        final Exception invalidOptionException = new InvalidOptionException();
        when(inputUtils.validateStringInput())
                .thenThrow(invalidOptionException)
                .thenReturn(password);

        when(this.fileUtils.readCharacterFromFile(password)).thenReturn(this.character);

        final Character result = target.execute();

        assertThat(result).isInstanceOf(Character.class).isEqualTo(this.character);
    }
}