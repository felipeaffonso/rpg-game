package com.challenge.engine;

import com.challenge.model.Character;
import com.challenge.model.CharacterClassEnum;

import java.util.Optional;
import java.util.Scanner;

public class GamePlayer implements GameAction{

    @Override
    public boolean execute() {
        final Character character = createCharacter();

        return false;
    }


    private Character createCharacter() {

        Character character;
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Type your character's name: ");
            final String name = sc.nextLine();

            Optional<CharacterClassEnum> optionalCharacterClassEnum;
            do {
                System.out.print("Type your character's class (1) Java (2) Python: ");
                final Integer classNumber = sc.nextInt();
                optionalCharacterClassEnum = CharacterClassEnum.findByClassNumber(classNumber);

            } while(!optionalCharacterClassEnum.isPresent());

            character = new Character(name, optionalCharacterClassEnum.get());

            System.out.println();
        }

        printCharacter(character);
        return character;
    }

    private void printCharacter(final Character character) {
        System.out.println("Here are your character details: ");
        System.out.println(character.toString());
        System.out.println();
    }

}