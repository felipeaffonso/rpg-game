package com.challenge.engine.fight;

import com.challenge.engine.utils.FileUtils;
import com.challenge.exception.CoffeeNirvanaException;
import com.challenge.model.Character;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

import static com.challenge.model.CharacterClassEnum.PYTHON_PROGRAMMER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GoCoffeeShopActionTest {

    @Mock
    private FileUtils fileUtils;

    @Mock
    private Random random;

    @InjectMocks
    private GoCoffeeShopAction target;

    private Character character;

    @Before
    public void setUp() {
        this.character = new Character("Coffee", PYTHON_PROGRAMMER);
    }

    @Test
    public void executeAction() {
        when(this.random.nextInt(5)).thenReturn(3);

        target.executeAction(this.character);

        assertThat(character.getCaffeineLevel()).isEqualTo(24);
    }

    @Test(expected = CoffeeNirvanaException.class)
    public void executeActionMustThrowNirvanaCoffeeExceptionWhenCaffeineLevelIsGreaterThanLimit() {
        when(this.random.nextInt(5)).thenReturn(30);

        target.executeAction(this.character);

        assertThat(character.getCaffeineLevel()).isEqualTo(51);
    }
}