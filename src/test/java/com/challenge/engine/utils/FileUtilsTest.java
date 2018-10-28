package com.challenge.engine.utils;

import com.challenge.model.Character;
import com.challenge.model.CharacterClassEnum;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing Real Objects to Force Save/Read from files
 */
public class FileUtilsTest {

    @Test
    public void saveCharacterToFile() {
        final Character character = new Character("Dummy", CharacterClassEnum.JAVA_PROGRAMMER);

        final String uuid = FileUtils.saveCharacterToFile(character);

        assertThat(uuid).isNotNull();
    }

    @Test
    public void readCharacterFromFile() {
        final String uuid = "14d37500-4774-4688-b439-0edfe3f16a8f";

        final Character character = FileUtils.readCharacterFromFile(uuid);

        assertThat(character)
                .isNotNull()
                .isInstanceOf(Character.class)
                .extracting("name")
                .contains("Dummy");
    }

}