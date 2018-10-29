package com.challenge.engine.menu;

import com.challenge.engine.utils.FileUtils;
import com.challenge.engine.utils.InputUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MenuActionFactoryTest {

    @Mock
    private FileUtils fileUtils;

    @Mock
    private InputUtils inputUtils;

    @InjectMocks
    private MenuActionFactory menuActionFactory;

    @Test(expected = IllegalArgumentException.class)
    public void findMenuActionMustThrowExceptionWithNullCommandId() {
        final Integer commandId = null;

        this.menuActionFactory.findMenuAction(commandId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findMenuActionMustThrowExceptionWithNegativeCommandId() {
        final Integer commandId = -2;

        this.menuActionFactory.findMenuAction(commandId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findMenuActionMustThrowExceptionWithInvalidCommandId() {
        final Integer commandId = 4;

        this.menuActionFactory.findMenuAction(commandId);
    }

    @Test
    public void findMenuActionMustReturnNewGameCommandWithItsCommandId() {
        final Integer commandId = 1;

        final MenuAction result = this.menuActionFactory.findMenuAction(commandId);

        assertThat(result).isInstanceOf(NewGameCommand.class);
    }

    @Test
    public void findMenuActionMustReturnLoadGameCommandWithItsCommandId() {
        final Integer commandId = 2;

        final MenuAction result = this.menuActionFactory.findMenuAction(commandId);

        assertThat(result).isInstanceOf(LoadGameCommand.class);
    }

    @Test
    public void findMenuActionMustReturnFinishGameCommandWithItsCommandId() {
        final Integer commandId = 3;

        final MenuAction result = this.menuActionFactory.findMenuAction(commandId);

        assertThat(result).isInstanceOf(FinishGameCommand.class);
    }

    @Test
    public void getAvailableOptions() {
        final Collection<Integer> availableOptions = this.menuActionFactory.getAvailableOptions();

        assertThat(availableOptions).hasSize(3).contains(1, 2, 3);
    }

}