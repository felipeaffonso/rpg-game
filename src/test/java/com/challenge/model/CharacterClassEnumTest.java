package com.challenge.model;

import org.junit.Test;

import java.util.Optional;

import static com.challenge.model.CharacterClassEnum.JAVA_PROGRAMMER;
import static org.assertj.core.api.Assertions.assertThat;


public class CharacterClassEnumTest {

    @Test
    public void findByClassNumberMustReturnEmptyWithInvalidNumber() {
        final Integer classNumber = 0;

        final Optional<CharacterClassEnum> result = CharacterClassEnum.findByClassNumber(classNumber);

        assertThat(result).isEmpty();
    }

    @Test
    public void findByClassNumberMustReturnEmptyWithNullNumber() {
        final Integer classNumber = null;

        final Optional<CharacterClassEnum> result = CharacterClassEnum.findByClassNumber(classNumber);

        assertThat(result).isEmpty();
    }

    @Test
    public void findByClassNumberMustValidClassWithValidNumber() {
        final Integer classNumber = 1;

        final Optional<CharacterClassEnum> result = CharacterClassEnum.findByClassNumber(classNumber);

        assertThat(result).isNotEmpty().get().isEqualTo(JAVA_PROGRAMMER);
    }

    @Test
    public void getId() {
        final Integer id = JAVA_PROGRAMMER.getId();

        assertThat(id).isEqualTo(1);
    }

    @Test
    public void getName() {
        final String name = JAVA_PROGRAMMER.getName();

        assertThat(name).isEqualToIgnoringCase("Java Programmer");
    }

    @Test
    public void getLanguage() {
        final String language = JAVA_PROGRAMMER.getLanguage();

        assertThat(language).isEqualToIgnoringCase("Java");
    }

    @Test
    public void getLanguageDamage() {
        final Integer languageDamage = JAVA_PROGRAMMER.getLanguageDamage();

        assertThat(languageDamage).isEqualTo(5);
    }

    @Test
    public void getDescription() {
        final String description = JAVA_PROGRAMMER.getDescription();

        assertThat(description)
                .isEqualToIgnoringCase("Java Programmer needs more line codes to drink a lot of coffee!");
    }
}