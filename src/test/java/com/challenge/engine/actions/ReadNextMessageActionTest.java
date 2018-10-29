package com.challenge.engine.actions;

import com.challenge.engine.fight.FightActionFactory;
import com.challenge.engine.fight.FindDisturbingPersonAtPrinter;
import com.challenge.engine.fight.GoCoffeeShopAction;
import com.challenge.exception.CoffeeNirvanaException;
import com.challenge.exception.DeadCharacterException;
import com.challenge.exception.EndGameException;
import com.challenge.model.Character;
import com.challenge.model.CharacterClassEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@PrepareForTest(ReadNextMessageAction.class)
public class ReadNextMessageActionTest {

    @Mock
    private Random random;

    @Mock
    private FightActionFactory fightActionFactory;

    @Mock
    private GoCoffeeShopAction goCoffeeShopAction;

    @Mock
    private FindDisturbingPersonAtPrinter findDisturbingPersonAtPrinter;

    private Character character;

    @InjectMocks
    private ReadNextMessageAction target;

    @Before
    public void setUp() throws Exception {
        this.character = new Character("Dummy", CharacterClassEnum.PYTHON_PROGRAMMER);
    }

    @Test(expected = EndGameException.class)
    public void executeActionMustReturnEndGameExceptionWhenRandomNextIntThrowsException() {
        final Exception randomException = new IllegalArgumentException();
        when(this.random.nextInt(anyInt())).thenThrow(randomException);

        target.executeAction(this.character);
    }

    @Test
    public void executeActionMustExecuteGoCoffeeWithItsCommandId() {
        when(this.random.nextInt(anyInt())).thenReturn(1);
        final Collection<Integer> availableOptions = Arrays.asList(1, 2, 3, 4);
        when(this.fightActionFactory.getAvailableOptions()).thenReturn(availableOptions);
        when(this.fightActionFactory.findFightAction(1)).thenReturn(goCoffeeShopAction);
        doNothing().when(this.goCoffeeShopAction).executeAction(character);

        target.executeAction(this.character);
    }

    @Test(expected = CoffeeNirvanaException.class)
    public void executeActionMustExecuteGoCoffeeWithItsCommandIdAndThrowCoffeeNirvanaException() {
        when(this.random.nextInt(anyInt())).thenReturn(1);
        final Collection<Integer> availableOptions = Arrays.asList(1, 2, 3, 4);
        when(this.fightActionFactory.getAvailableOptions()).thenReturn(availableOptions);
        when(this.fightActionFactory.findFightAction(1)).thenReturn(goCoffeeShopAction);
        final Exception nirvanaCoffeeException = new CoffeeNirvanaException("Dummy Nirvana");
        doThrow(nirvanaCoffeeException).when(goCoffeeShopAction).executeAction(character);

        target.executeAction(this.character);
    }

    @Test(expected = DeadCharacterException.class)
    public void executeActionMustExecuteFindDisturbingPersonAtPrinterAndThrowDeadCharacterException() {
        when(this.random.nextInt(anyInt())).thenReturn(4);
        final Collection<Integer> availableOptions = Arrays.asList(1, 2, 3, 4);
        when(this.fightActionFactory.getAvailableOptions()).thenReturn(availableOptions);
        when(this.fightActionFactory.findFightAction(4)).thenReturn(findDisturbingPersonAtPrinter);
        final Exception deadCharacterException = new DeadCharacterException("Dummy Death");
        doThrow(deadCharacterException).when(findDisturbingPersonAtPrinter).executeAction(character);

        target.executeAction(this.character);
    }

}