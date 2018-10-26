package com.challenge.model;

import java.util.Arrays;
import java.util.Optional;

public enum CharacterClassEnum {

    JAVA_PROGRAMMER(1, "Java Programmer", "Java", 10, "Java Programmer used to drink a lot of coffee!"),
    PYTHON_PROGRAMMER(2, "Python Geek", "Python", 8, "Python Programmer is a geek that can code really fast!");

    private Integer number;

    private String name;

    private String language;

    private Integer languageDamage;

    private String description;

    CharacterClassEnum(final Integer number, final String name, final String language, final Integer languageDamage,
                       final String description) {
        this.number = number;
        this.name = name;
        this.language = language;
        this.languageDamage = languageDamage;
        this.description = description;
    }

    public static Optional<CharacterClassEnum> findByClassNumber(final Integer classNumber) {
        return Arrays.stream(CharacterClassEnum.values()).filter(clazz -> clazz.getNumber().equals(classNumber)).findFirst();
    }

    public Integer getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getLanguageDamage() {
        return languageDamage;
    }

    public String getDescription() {
        return description;
    }
}