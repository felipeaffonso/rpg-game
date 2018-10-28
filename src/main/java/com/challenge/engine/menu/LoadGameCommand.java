package com.challenge.engine.menu;

import com.challenge.engine.utils.FileUtils;
import com.challenge.engine.utils.InputUtils;
import com.challenge.exception.InvalidCharacterNameException;
import com.challenge.exception.InvalidOptionException;
import com.challenge.model.Character;

public class LoadGameCommand implements MenuAction {

    @Override
    public Character execute() {
        InputUtils.clearConsole();
        String password = null;
        boolean validPassword = false;
        do {
            try{
                System.out.print("Type your Game Password: " );
                password = validateInputPassword();
                validPassword = true;
            } catch(final InvalidCharacterNameException e) {
                System.err.println(e.getMessage());
            }
        } while (!validPassword);


        final Character character = FileUtils.readCharacterFromFile(password);
        character.printDetails();

        return character;
    }

    private String validateInputPassword() {
        try {
            return InputUtils.validateStringInput();
        } catch(final InvalidOptionException ioe) {
            throw new InvalidCharacterNameException("Invalid Game Password, please type another one");
        }
    }
}
