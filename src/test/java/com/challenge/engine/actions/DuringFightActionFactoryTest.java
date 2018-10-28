package com.challenge.engine.actions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DuringFightActionFactoryTest {

    @InjectMocks
    private DuringGameActionFactory duringGameActionFactory;

    @Test(expected = AssertionError.class)
    public void findDuringGameActionMustThrowExceptionWithNullCommandId() {
        final Integer commandId = null;

        this.duringGameActionFactory.findDuringGameAction(commandId);
    }

    @Test(expected = AssertionError.class)
    public void findDuringGameActionMustThrowExceptionWithNegativeCommandId() {
        final Integer commandId = -2;

        this.duringGameActionFactory.findDuringGameAction(commandId);
    }

    @Test(expected = AssertionError.class)
    public void findDuringGameActionMustThrowExceptionWithInvalidCommandId() {
        final Integer commandId = 4;

        this.duringGameActionFactory.findDuringGameAction(commandId);
    }

    @Test
    public void findDuringGameActionMustReturnReadNextMessageActionWithItsCommandId() {
        final Integer commandId = 1;

        final DuringGameAction result = this.duringGameActionFactory.findDuringGameAction(commandId);

        assertThat(result).isInstanceOf(ReadNextMessageAction.class);
    }

    @Test
    public void findDuringGameActionMustReturnSaveGameAndExitActionWithItsCommandId() {
        final Integer commandId = 2;

        final DuringGameAction result = this.duringGameActionFactory.findDuringGameAction(commandId);

        assertThat(result).isInstanceOf(SaveGameAndExitAction.class);
    }

    @Test
    public void findDuringGameActionMustReturnAbandonGameActionWithItsCommandId() {
        final Integer commandId = 3;

        final DuringGameAction result = this.duringGameActionFactory.findDuringGameAction(commandId);

        assertThat(result).isInstanceOf(AbandonGameAction.class);
    }
}