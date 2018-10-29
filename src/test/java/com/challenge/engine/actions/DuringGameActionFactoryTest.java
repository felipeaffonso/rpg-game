package com.challenge.engine.actions;

import com.challenge.engine.fight.FightActionFactory;
import com.challenge.engine.utils.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DuringGameActionFactoryTest {

    @Mock
    private FileUtils fileUtils;

    @Mock
    private Random random;

    @Mock
    private FightActionFactory fightActionFactory;

    @InjectMocks
    private DuringGameActionFactory target;

    @Test(expected = IllegalArgumentException.class)
    public void findDuringGameActionMustThrowExceptionWithNullCommandId() {
        final Integer commandId = null;

        this.target.findDuringGameAction(commandId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findDuringGameActionMustThrowExceptionWithNegativeCommandId() {
        final Integer commandId = -2;

        this.target.findDuringGameAction(commandId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findDuringGameActionMustThrowExceptionWithInvalidCommandId() {
        final Integer commandId = 4;

        this.target.findDuringGameAction(commandId);
    }

    @Test
    public void findDuringGameActionMustReturnReadNextMessageActionWithItsCommandId() {
        final Integer commandId = 1;

        final DuringGameAction result = this.target.findDuringGameAction(commandId);

        assertThat(result).isInstanceOf(ReadNextMessageAction.class);
    }

    @Test
    public void findDuringGameActionMustReturnSaveGameAndExitActionWithItsCommandId() {
        final Integer commandId = 2;

        final DuringGameAction result = this.target.findDuringGameAction(commandId);

        assertThat(result).isInstanceOf(SaveGameAndExitAction.class);
    }

    @Test
    public void findDuringGameActionMustReturnAbandonGameActionWithItsCommandId() {
        final Integer commandId = 3;

        final DuringGameAction result = this.target.findDuringGameAction(commandId);

        assertThat(result).isInstanceOf(AbandonGameAction.class);
    }

    @Test
    public void getAvailableOptionsMustReturnCollection() {
        final Collection<Integer> result = target.getAvailableOptions();

        assertThat(result).hasSize(3).contains(1, 2, 3);
    }
}