package com.challenge.engine.utils;

import com.challenge.exception.EndGameException;
import com.challenge.model.Character;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FileUtils {

    private static final String FILES = "files/";
    private static final String FILE_EXTENSION = ".bkp";

    public String saveCharacterToFile(final Character character) {
        final String uuid = UUID.randomUUID().toString();
        final Path path = Paths.get(FILES + uuid + FILE_EXTENSION);
        try (
                final FileOutputStream fos = new FileOutputStream(path.toFile());
                final ObjectOutputStream oos = new ObjectOutputStream(fos)
        ){
            oos.writeObject(character);
            return uuid;
        } catch (Exception e) {
            throw new EndGameException("Failed Saving your progress. Sorry :-( Game Over!");
        }
    }

    public Character readCharacterFromFile(final String uuid) {
        final Path path = Paths.get(FILES + uuid + FILE_EXTENSION);
        try (
                final FileInputStream fis = new FileInputStream(path.toFile());
                final ObjectInputStream ois = new ObjectInputStream(fis)
        ){
            return (Character) ois.readObject();
        } catch (Exception e) {
            throw new EndGameException("I could not find Game Progress with the specified password.\n" +
                    "Check the password and try again :-)");
        }
    }

    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (final InterruptedException e) {
            //Just jump a line when Thread.sleep fails
            System.out.println();
        }
    }

}