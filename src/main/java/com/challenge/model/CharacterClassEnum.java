package com.challenge.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public enum CharacterClassEnum implements Serializable {

    JAVA_PROGRAMMER(1, "Java Programmer", "Java", 3, "Java Programmer needs more line codes to drink a lot of coffee!"),
    PYTHON_PROGRAMMER(2, "Python Geek", "Python", 4, "Python Programmer is a geek that can code really fast!"),
    JAVASCRIPT_PROGRAMMER(3, "JS.programmer.min.bundle", "Javascript", 5, "While you read this, 7 new JS frameworks were launched");

    private Integer id;

    private String name;

    private String language;

    private Integer languageDamage;

    private String description;

    CharacterClassEnum(final Integer id, final String name, final String language, final Integer languageDamage,
                       final String description) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.languageDamage = languageDamage;
        this.description = description;
    }

    public static Optional<CharacterClassEnum> findByClassNumber(final Integer classNumber) {
        return Optional.ofNullable(classNumber)
                .flatMap(number -> Arrays.stream(CharacterClassEnum.values())
                    .filter(clazz -> clazz.getId().equals(classNumber))
                    .findFirst());
    }

    public Integer getId() {
        return id;
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

    public static Collection<Integer> getAvailableIds() {
        return Arrays.stream(values())
                .map(CharacterClassEnum::getId)
                .collect(Collectors.toList());
    }


    @Override
    public String toString() {
        return "CharacterClassEnum{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", languageDamage=" + languageDamage +
                ", description='" + description + '\'' +
                '}';
    }
}