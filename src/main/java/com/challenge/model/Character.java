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
        assert Objects.nonNull(damage) && damage > 0;
        if(this.caffeineLevel - damage <= 0) {
            this.alive = false;
            this.caffeineLevel = 0;
            throw new DeadCharacterException("You are dead :-(");
        }
        this.caffeineLevel -= damage;
    }

    public void drinkCoffee(final Integer quantity) {
        assert Objects.nonNull(quantity) && quantity > 0;
        this.caffeineLevel += quantity;
        if(caffeineLevel >= 50) {
            throw new CoffeeNirvanaException("Congratulations! You've just reached 'Coffee Nirvana' state of mind!'");
        }
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                ", caffeineLevel=" + caffeineLevel +
                ", alive=" + alive +
                '}';
    }

    public void printDetails() {
        System.out.println("Here are your character details: ");
        System.out.println(this.toString());
        System.out.println();
    }
}