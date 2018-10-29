package com.challenge;

import com.challenge.engine.menu.MainMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GameApplicationTest {

    @InjectMocks
    private GameApplication target;

    @Test
    public void setup() {
        final MainMenu result = target.setup();

        assertThat(result).isInstanceOf(MainMenu.class);
    }
}