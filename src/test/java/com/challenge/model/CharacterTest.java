package com.challenge.model;

import com.challenge.exception.CoffeeNirvanaException;
import com.challenge.exception.DeadCharacterException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class CharacterTest {

    private Character character;

    @Before
    public void setUp() {
        this.character = new Character("Dummy", CharacterClassEnum.JAVA_PROGRAMMER);
    }

    @Test(expected = AssertionError.class)
    public void constructorWithoutNameMustThrowException() {
        final String name = null;
        final CharacterClassEnum clazz = null;

        new Character(name, clazz);
    }

    @Test(expected = AssertionError.class)
    public void constructorWithNameWithoutClassMustThrowException() {
        final String name = "Dummy";
        final CharacterClassEnum clazz = null;

        new Character(name, clazz);
    }

    @Test
    public void getNameMustReturnValidName() {
        final String name = this.character.getName();

        assertThat(name).isEqualToIgnoringCase("Dummy");
    }

    @Test
    public void getClazz() {
        final CharacterClassEnum clazz = this.character.getClazz();

        assertThat(clazz).isEqualByComparingTo(CharacterClassEnum.JAVA_PROGRAMMER);
    }

    @Test
    public void getCaffeineLevel() {
        final Integer caffeineLevel = this.character.getCaffeineLevel();

        assertThat(caffeineLevel).isEqualTo(20);
    }

    @Test
    public void getAlive() {
        final Boolean alive = this.character.getAlive();

        assertThat(alive).isTrue();
    }

    @Test
    public void getDead() {
        try {
            this.character.receiveDamage(20);
        } catch (DeadCharacterException de) {
            //do nothing, checking the alive status
        }
        final Boolean alive = this.character.getAlive();

        assertThat(alive).isFalse();
    }

    @Test(expected = AssertionError.class)
    public void receiveDamageMustThrowExceptionWithNullDamage() {
        final Integer damage = null;

        this.character.receiveDamage(damage);
    }

    @Test(expected = AssertionError.class)
    public void receiveDamageMustThrowExceptionWithZeroDamage() {
        final Integer damage = 0;

        this.character.receiveDamage(damage);
    }

    @Test(expected = AssertionError.class)
    public void receiveDamageMustThrowExceptionWithNegativeDamage() {
        final Integer damage = -1;

        this.character.receiveDamage(damage);
    }

    @Test
    public void receiveDamageMustDecreaseCaffeineLevelWithPositiveDamage() {
        final Integer damage = 10;

        this.character.receiveDamage(damage);

        assertThat(this.character)
                .extracting("alive", "caffeineLevel")
                .contains(Boolean.TRUE, 10);
    }

    @Test(expected = DeadCharacterException.class)
    public void receiveDamageMustKillCharacterWithFatalDamage() {
        final Integer damage = 20;

        this.character.receiveDamage(damage);
    }

    @Test(expected = AssertionError.class)
    public void drinkCoffeeMustThrowExceptionWithNullQuantity() {
        final Integer quantity = null;

        this.character.drinkCoffee(quantity);
    }

    @Test(expected = AssertionError.class)
    public void drinkCoffeeMustThrowExceptionWithInvalidQuantity() {
        final Integer quantity = -1;

        this.character.drinkCoffee(quantity);
    }

    @Test
    public void drinkCoffeeMustIncreaseCaffeineLevelWithValidQuantity() {
        final Integer quantity = 20;

        this.character.drinkCoffee(quantity);

        assertThat(this.character.getCaffeineLevel()).isEqualTo(40);
    }

    @Test(expected = CoffeeNirvanaException.class)
    public void drinkCoffeeMustIncreaseCaffeineLevelButThrownNirvanaCoffeeExceptionWithWinnerQuantity() {
        final Integer quantity = 55;

        this.character.drinkCoffee(quantity);
    }
}