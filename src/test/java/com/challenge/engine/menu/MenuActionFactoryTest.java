package com.challenge.engine.menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MenuActionFactoryTest {


    @InjectMocks
    private MenuActionFactory menuActionFactory;

    @Test(expected = AssertionError.class)
    public void findMenuActionMustThrowExceptionWithNullCommandId() {
        final Integer commandId = null;

        this.menuActionFactory.findMenuAction(commandId);
    }

    @Test(expected = AssertionError.class)
    public void findMenuActionMustThrowExceptionWithNegativeCommandId() {
        final Integer commandId = -2;

        this.menuActionFactory.findMenuAction(commandId);
    }

    @Test(expected = AssertionError.class)
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
}