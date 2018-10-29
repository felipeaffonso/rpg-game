package com.challenge.engine.fight;

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
public class FightActionFactoryTest {

    @Mock
    private FileUtils fileUtils;

    @Mock
    private Random random;

    @InjectMocks
    private FightActionFactory target;

    @Test(expected = IllegalArgumentException.class)
    public void findFightActionMustThrowExceptionWithNullCommandId() {
        final Integer commandId = null;

        this.target.findFightAction(commandId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFightActionMustThrowExceptionWithNegativeCommandId() {
        final Integer commandId = -2;

        this.target.findFightAction(commandId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFightActionMustThrowExceptionWithInvalidCommandId() {
        final Integer commandId = 4;

        this.target.findFightAction(commandId);
    }

    @Test
    public void findFightActionMustReturnGoCoffeeShopWithItsCommandId() {
        final Integer commandId = 0;

        final FightAction result = this.target.findFightAction(commandId);

        assertThat(result).isInstanceOf(GoCoffeeShopAction.class);
    }

    @Test
    public void findFightActionMustFindMonsterBugActionWithItsCommandId() {
        final Integer commandId = 1;

        final FightAction result = this.target.findFightAction(commandId);

        assertThat(result).isInstanceOf(FindMonsterBugAction.class);
    }

    @Test
    public void findFightActionMustReturnAnswerBossMomActionWithItsCommandId() {
        final Integer commandId = 2;

        final FightAction result = this.target.findFightAction(commandId);

        assertThat(result).isInstanceOf(AnswerBossMomAction.class);
    }

    @Test
    public void findFightActionMustReturnFindDisturbingPersonAtPrinterWithItsCommandId() {
        final Integer commandId = 3;

        final FightAction result = this.target.findFightAction(commandId);

        assertThat(result).isInstanceOf(FindDisturbingPersonAtPrinter.class);
    }

    @Test
    public void getAvailableOptionsMustReturnCollection() {
        final Collection<Integer> result = target.getAvailableOptions();

        assertThat(result).hasSize(4).contains(0, 1, 2, 3);
    }
}