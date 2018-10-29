package com.challenge.engine.fight;

import com.challenge.engine.utils.FileUtils;
import com.challenge.exception.CoffeeNirvanaException;
import com.challenge.exception.DeadCharacterException;
import com.challenge.model.Character;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

import static com.challenge.model.CharacterClassEnum.JAVA_PROGRAMMER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AnswerBossMomActionTest {

    @Mock
    private FileUtils fileUtils;

    @Mock
    private Random random;

    @InjectMocks
    private AnswerBossMomAction target;

    private Character character;

    @Before
    public void setUp() throws Exception {
        this.character = new Character("Answer Boss", JAVA_PROGRAMMER);
    }

    @Test
    public void executeActionCorrectedFiveAndLeftFiveBugs() {
        when(this.random.nextInt(anyInt()))
                .thenReturn(9)
                .thenReturn(5);

        target.executeAction(this.character);

        assertThat(this.character.getCaffeineLevel()).isEqualTo(25);
    }

    @Test(expected = CoffeeNirvanaException.class)
    public void executeActionMustThrowCoffeeNirvanaExceptionWhenCaffeineLevelIsHigherThanLimit() {
        when(this.random.nextInt(anyInt()))
                .thenReturn(9)
                .thenReturn(10);

        target.executeAction(this.character);
        target.executeAction(this.character);
    }

    @Test(expected = DeadCharacterException.class)
    public void executeActionMustThrowDeadCharacterExceptionWhenCaffeineLevelIsLowerThanLimit() {
        when(this.random.nextInt(anyInt()))
                .thenReturn(25)
                .thenReturn(1);

        target.executeAction(this.character);
    }

}