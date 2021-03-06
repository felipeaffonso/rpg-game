package com.challenge.model;

import com.challenge.exception.CoffeeNirvanaException;
import com.challenge.exception.DeadCharacterException;

import java.io.Serializable;
import java.util.Objects;

public class Character implements Serializable {

    private static final Long serialVersionId = 1L;

    private String name;

    private CharacterClassEnum clazz;

    private Integer caffeineLevel;

    private Boolean alive;

    public Character(final String name, final CharacterClassEnum clazz) {
        assert Objects.nonNull(name);
        assert Objects.nonNull(clazz);
        this.name = name;
        this.clazz = clazz;
        this.caffeineLevel = 20;
        this.alive = Boolean.TRUE;
    }

    public String getName() {
        return name;
    }

    public CharacterClassEnum getClazz() {
        return clazz;
    }

    public Integer getCaffeineLevel() {
        return caffeineLevel;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void receiveDamage(final Integer damage) throws DeadCharacterException {
        if(Objects.isNull(damage) || damage < 0) {
            throw new IllegalArgumentException();
        }
        if(this.caffeineLevel - damage <= 0) {
            this.alive = false;
            this.caffeineLevel = 0;
            throw new DeadCharacterException("You are dead :-(");
        }
        this.caffeineLevel -= damage;
    }

    public void drinkCoffee(final Integer quantity) {
        if(Objects.isNull(quantity) || quantity < 0) {
            throw new IllegalArgumentException();
        }
        this.caffeineLevel += quantity;
        if(caffeineLevel >= 50) {
            throw new CoffeeNirvanaException("Congratulations! You've just reached 'Coffee Nirvana' state of mind!'");
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Class: " + this.clazz.getName() + " - Language Damage: " + this.clazz.getLanguageDamage() + "\n" +
                "Caffeine Level: " + caffeineLevel;
    }

    public void printDetails() {
        System.out.println("\n_________________________________________________________________________________________");
        System.out.println("Current Status: ");
        System.out.println(this.toString());
        System.out.println("_________________________________________________________________________________________");
    }

}