package com.challenge.engine.menu;

import com.challenge.engine.GameEngine;
import com.challenge.engine.utils.InputUtils;
import com.challenge.exception.CoffeeNirvanaException;
import com.challenge.exception.DeadCharacterException;
import com.challenge.exception.EndGameException;
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
import org.powermock.api.mockito.PowerMockito;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainMenuTest {

    @Mock
    private MenuActionFactory menuActionFactory;

    @Mock
    private GameEngine gameEngine;

    @Mock
    private InputUtils inputUtils;

    @Mock
    private NewGameCommand newGameCommand;

    @Mock
    private LoadGameCommand loadGameCommand;

    @Mock
    private FinishGameCommand finishGameCommand;

    @InjectMocks
    private MainMenu target;

    @Before
    public void setUp() throws Exception {
        PowerMockito.whenNew(InputUtils.class).withAnyArguments().thenReturn(inputUtils);
    }

    @Test
    public void startGameMenuMustCallGameEngineWhenNewGameCommandReturnNewCharacter() {
        final List<Integer> availableOptions = asList(1, 2, 3);
        when(menuActionFactory.getAvailableOptions()).thenReturn(availableOptions);
        when(inputUtils.validateIntegerInput(availableOptions)).thenReturn(2);

        when(menuActionFactory.findMenuAction(2)).thenReturn(loadGameCommand);
        final Character character = new Character("Dummy", CharacterClassEnum.JAVASCRIPT_PROGRAMMER);
        when(loadGameCommand.execute()).thenReturn(character);

        target.startGameMenu();

        Mockito.verify(gameEngine, Mockito.times(1)).startGame(character);
    }

    @Test
    public void startGameMenuMustCallGameEngineWhenNewGameCommandReturnNewCharacterForTheSecondInput() {
        final List<Integer> availableOptions = asList(1, 2, 3);
        when(menuActionFactory.getAvailableOptions()).thenReturn(availableOptions).thenReturn(availableOptions);
        final Exception invalidOptionException = new InvalidOptionException();
        when(inputUtils.validateIntegerInput(availableOptions)).thenThrow(invalidOptionException).thenReturn(2);

        when(menuActionFactory.findMenuAction(2)).thenReturn(loadGameCommand);
        final Character character = new Character("Dummy", CharacterClassEnum.JAVASCRIPT_PROGRAMMER);
        when(loadGameCommand.execute()).thenReturn(character);

        target.startGameMenu();

        Mockito.verify(gameEngine, Mockito.times(1)).startGame(character);
    }

    @Test
    public void startGameMenuMustCallGameEngineWhenLoadGameCommandReturnRecoveredCharacter() {
        final List<Integer> availableOptions = asList(1, 2, 3);
        when(menuActionFactory.getAvailableOptions()).thenReturn(availableOptions);
        when(inputUtils.validateIntegerInput(availableOptions)).thenReturn(1);

        when(menuActionFactory.findMenuAction(1)).thenReturn(newGameCommand);
        final Character character = new Character("Dummy", CharacterClassEnum.JAVASCRIPT_PROGRAMMER);
        when(newGameCommand.execute()).thenReturn(character);

        target.startGameMenu();

        Mockito.verify(gameEngine, Mockito.times(1)).startGame(character);
    }

    @Test(expected = EndGameException.class)
    public void startGameMenuMustThrowEndGameExceptionWhenFinishGameCommandIsCalled() {
        final List<Integer> availableOptions = asList(1, 2, 3);
        when(menuActionFactory.getAvailableOptions()).thenReturn(availableOptions);
        when(inputUtils.validateIntegerInput(availableOptions)).thenReturn(1);

        when(menuActionFactory.findMenuAction(1)).thenReturn(finishGameCommand);
        final Exception exception = new EndGameException("Dummy EndGame");
        when(finishGameCommand.execute()).thenThrow(exception);

        target.startGameMenu();

        Mockito.verify(gameEngine, Mockito.times(0)).startGame(Mockito.any());
    }

    @Test(expected = EndGameException.class)
    public void startGameMenuMustThrowEndGameExceptionWhenGameEngineThrowsEndGameException() {
        final List<Integer> availableOptions = asList(1, 2, 3);
        when(menuActionFactory.getAvailableOptions()).thenReturn(availableOptions);
        when(inputUtils.validateIntegerInput(availableOptions)).thenReturn(1);

        when(menuActionFactory.findMenuAction(1)).thenReturn(newGameCommand);
        final Character character = new Character("Dummy", CharacterClassEnum.JAVASCRIPT_PROGRAMMER);
        when(newGameCommand.execute()).thenReturn(character);

        final Exception exception = new EndGameException("Dummy EndGame");
        doThrow(exception).when(gameEngine).startGame(character);

        target.startGameMenu();
    }

    @Test(expected = DeadCharacterException.class)
    public void startGameMenuMustThrowDeadCharacterExceptionWhenGameEngineThrowsDeadCharacterException() {
        final List<Integer> availableOptions = asList(1, 2, 3);
        when(menuActionFactory.getAvailableOptions()).thenReturn(availableOptions);
        when(inputUtils.validateIntegerInput(availableOptions)).thenReturn(1);

        when(menuActionFactory.findMenuAction(1)).thenReturn(newGameCommand);
        final Character character = new Character("Dummy", CharacterClassEnum.JAVASCRIPT_PROGRAMMER);
        when(newGameCommand.execute()).thenReturn(character);

        final Exception exception = new DeadCharacterException("Dummy EndGame");
        doThrow(exception).when(gameEngine).startGame(character);

        target.startGameMenu();
    }

    @Test(expected = CoffeeNirvanaException.class)
    public void startGameMenuMustThrowCoffeeNirvanaExceptionWhenGameEngineThrowsCoffeeNirvanaException() {
        final List<Integer> availableOptions = asList(1, 2, 3);
        when(menuActionFactory.getAvailableOptions()).thenReturn(availableOptions);
        when(inputUtils.validateIntegerInput(availableOptions)).thenReturn(1);

        when(menuActionFactory.findMenuAction(1)).thenReturn(newGameCommand);
        final Character character = new Character("Dummy", CharacterClassEnum.JAVASCRIPT_PROGRAMMER);
        when(newGameCommand.execute()).thenReturn(character);

        final Exception exception = new CoffeeNirvanaException("Dummy EndGame");
        doThrow(exception).when(gameEngine).startGame(character);

        target.startGameMenu();
    }

    @Test(expected = EndGameException.class)
    public void startGameMenuMustThrowEndGameExceptionWhenGameEngineThrowsUnexpectedException() {
        final List<Integer> availableOptions = asList(1, 2, 3);
        when(menuActionFactory.getAvailableOptions()).thenReturn(availableOptions);
        when(inputUtils.validateIntegerInput(availableOptions)).thenReturn(1);

        when(menuActionFactory.findMenuAction(1)).thenReturn(newGameCommand);
        final Character character = new Character("Dummy", CharacterClassEnum.PYTHON_PROGRAMMER);
        when(newGameCommand.execute()).thenReturn(character);

        final Exception exception = new NullPointerException("Dummy NullPointer");
        doThrow(exception).when(gameEngine).startGame(character);

        target.startGameMenu();
    }
}