package com.challenge.model;

import com.challenge.exception.DeadCharacterException;

public class Character {

    private String name;

    private CharacterClassEnum clazz;

    private Integer caffeineLevel;

    private Integer correctedBugs;

    private Boolean alive;

    public Character(final String name, final CharacterClassEnum clazz) {
        this.name = name;
        this.clazz = clazz;
        this.caffeineLevel = 20;
        this.correctedBugs = 0;
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

    public Integer getCorrectedBugs() {
        return correctedBugs;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void receiveDamage(final Integer damage) throws DeadCharacterException {
        if(this.caffeineLevel - damage <= 0) {
            throw new DeadCharacterException("You are dead :-(");
        }
        this.caffeineLevel -= damage;
    }

    public void correctBugs(final Integer correctedBugs) {
        this.correctedBugs += correctedBugs;
    }


    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz.toString() +
                ", caffeineLevel=" + caffeineLevel +
                ", correctedBugs=" + correctedBugs +
                ", alive=" + alive +
                '}';
    }
}