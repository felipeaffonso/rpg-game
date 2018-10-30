package com.challenge.engine.menu;

import com.challenge.engine.utils.FileUtils;
import com.challenge.engine.utils.InputUtils;
import com.challenge.exception.InvalidOptionException;
import com.challenge.model.Character;
import com.challenge.model.CharacterClassEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;

import static com.challenge.model.CharacterClassEnum.JAVA_PROGRAMMER;
import static com.challenge.model.CharacterClassEnum.getAvailableIds;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NewGameCommandTest {

    private static final String DUMMY_NAME = "Dummy Name";

    @Mock
    private InputUtils inputUtils;

    @Mock
    private FileUtils fileUtils;

    @InjectMocks
    private NewGameCommand target;

    private Character character;

    @Before
    public void setUp() {
        this.character = new Character(DUMMY_NAME, JAVA_PROGRAMMER);
    }

    @Test
    public void executeMustCreateCharacterWithInputErrorHandling() {
        when(this.fileUtils.getString(anyString())).thenReturn("");

        final Exception invalidOptionException = new InvalidOptionException();

        when(this.inputUtils.validateStringInput())
                .thenThrow(invalidOptionException)
                .thenReturn(DUMMY_NAME);

        final Collection<Integer> availableIds = getAvailableIds();

        final Integer validClassId = 1;
        final Integer invalidClassId = 4;

        when(this.inputUtils.validateIntegerInput(availableIds))
                .thenThrow(invalidOptionException)
                .thenReturn(invalidClassId)
                .thenReturn(validClassId);

        final Character result = target.execute();

        assertThat(result).isNotNull().isInstanceOf(Character.class)
                .isEqualToComparingFieldByField(this.character);
    }
}