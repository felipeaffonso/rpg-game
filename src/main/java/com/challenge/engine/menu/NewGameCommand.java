package com.challenge.engine.menu;

import com.challenge.engine.utils.InputUtils;
import com.challenge.exception.InvalidCharacterNameException;
import com.challenge.exception.InvalidOptionException;
import com.challenge.model.Character;
import com.challenge.model.CharacterClassEnum;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class NewGameCommand implements MenuAction {

    @Override
    public Character execute() {
        InputUtils.clearConsole();
        String name = null;
        boolean validName = false;
        do {
            try{
                System.out.print("Type your character's name: " );
                name = validateInputName();
                validName = true;
            } catch(final InvalidCharacterNameException e) {
                System.err.println(e.getMessage());
            }
        } while (!validName);

        CharacterClassEnum characterClassEnum = null;
        do {
            try {
                System.out.print("Type your character's class (1) Java (2) Python (3) JavaScript: ");
                final Integer classNumber = InputUtils.validateIntegerInput(CharacterClassEnum.getAvailableIds());
                characterClassEnum = selectCharacterClass(classNumber);
            } catch(final InvalidOptionException e) {
                System.err.println("Invalid Class, please select a valid option");
            }
        } while(Objects.isNull(characterClassEnum));

        final Character character = new Character(name, characterClassEnum);
        character.printDetails();
        return character;
    }

    private CharacterClassEnum selectCharacterClass(final Integer classNumber) {
        return CharacterClassEnum.findByClassNumber(classNumber)
                .orElseThrow(InvalidOptionException::new);
    }

    private String validateInputName() {
        try {
            return InputUtils.validateStringInput();
        } catch(final InvalidOptionException ioe) {
            throw new InvalidCharacterNameException("Invalid name, please type another one");
        }
    }

}