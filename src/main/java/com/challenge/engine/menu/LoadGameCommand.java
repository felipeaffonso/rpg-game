package com.challenge.engine.menu;

import com.challenge.engine.utils.FileUtils;
import com.challenge.engine.utils.InputUtils;
import com.challenge.exception.InvalidCharacterNameException;
import com.challenge.exception.InvalidOptionException;
import com.challenge.model.Character;

public class LoadGameCommand implements MenuAction {

    private final InputUtils inputUtils;
    private final FileUtils fileUtils;

    LoadGameCommand(InputUtils inputUtils, FileUtils fileUtils) {
        this.inputUtils = inputUtils;
        this.fileUtils = fileUtils;
    }

    @Override
    public Character execute() {
        String password = null;
        boolean validPassword = false;
        do {
            try{
                System.out.print(this.fileUtils.getString("game.requestPassword"));
                password = validateInputPassword();
                validPassword = true;
            } catch(final InvalidCharacterNameException e) {
                System.err.println(e.getMessage());
            }
        } while (!validPassword);


        final Character character = this.fileUtils.readCharacterFromFile(password);
        character.printDetails();

        return character;
    }

    private String validateInputPassword() {
        try {
            return inputUtils.validateStringInput();
        } catch(final InvalidOptionException ioe) {
            throw new InvalidCharacterNameException(this.fileUtils.getString("game.invalidPassword"));
        }
    }

}