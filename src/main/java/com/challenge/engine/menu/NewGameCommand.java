package com.challenge.engine.menu;

import com.challenge.engine.utils.FileUtils;
import com.challenge.engine.utils.InputUtils;
import com.challenge.exception.InvalidCharacterNameException;
import com.challenge.exception.InvalidOptionException;
import com.challenge.model.Character;
import com.challenge.model.CharacterClassEnum;

import java.text.MessageFormat;
import java.util.Objects;

import static com.challenge.model.CharacterClassEnum.JAVASCRIPT_PROGRAMMER;
import static com.challenge.model.CharacterClassEnum.JAVA_PROGRAMMER;
import static com.challenge.model.CharacterClassEnum.PYTHON_PROGRAMMER;
import static java.text.MessageFormat.format;

public class NewGameCommand implements MenuAction {

    private final InputUtils inputUtils;

    private final FileUtils fileUtils;

    NewGameCommand(final InputUtils inputUtils, final FileUtils fileUtils) {
        this.inputUtils = inputUtils;
        this.fileUtils = fileUtils;
    }

    @Override
    public Character execute() {
        String name = null;
        boolean validName = false;
        do {
            try{
                System.out.print(fileUtils.getString("game.requestName"));
                name = validateInputName();
                validName = true;
            } catch(final InvalidCharacterNameException e) {
                System.err.println(e.getMessage());
            }
        } while (!validName);

        CharacterClassEnum characterClassEnum = null;
        do {
            try {
                System.out.println(this.fileUtils.getString("game.classesIntro"));
                System.out.println(getClassesMessage());
                System.out.print(fileUtils.getString("game.requestClass"));
                final Integer classNumber = inputUtils.validateIntegerInput(CharacterClassEnum.getAvailableIds());
                characterClassEnum = selectCharacterClass(classNumber);
            } catch(final InvalidOptionException e) {
                System.err.println(this.fileUtils.getString("game.error.invalidClass"));
            }
        } while(Objects.isNull(characterClassEnum));

        final Character character = new Character(name, characterClassEnum);
        character.printDetails();
        this.fileUtils.waitSeconds(2);
        return character;
    }

    private String getClassesMessage() {
        return format(this.fileUtils.getString("game.classes"),
                JAVA_PROGRAMMER.toString(),
                PYTHON_PROGRAMMER.toString(),
                JAVASCRIPT_PROGRAMMER.toString());
    }

    private CharacterClassEnum selectCharacterClass(final Integer classNumber) {
        return CharacterClassEnum.findByClassNumber(classNumber)
                .orElseThrow(InvalidOptionException::new);
    }

    private String validateInputName() {
        try {
            return inputUtils.validateStringInput();
        } catch(final InvalidOptionException ioe) {
            throw new InvalidCharacterNameException(this.fileUtils.getString("game.error.invalidName"));
        }
    }

}