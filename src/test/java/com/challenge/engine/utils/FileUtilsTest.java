package com.challenge.engine.utils;

import com.challenge.exception.EndGameException;
import com.challenge.model.Character;
import com.challenge.model.CharacterClassEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.*;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Testing Real Objects to Force Save/Read from files
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ FileUtils.class, File.class, ObjectInputStream.class,
        FileInputStream.class, ObjectOutputStream.class, FileOutputStream.class })

public class FileUtilsTest {

    @Mock
    private Paths paths;

    @Mock
    private File mockedFile;

    @Mock
    private ObjectInputStream ois;

    @Mock
    private ObjectOutputStream oos;

    @Mock
    private FileOutputStream fos;

    @Mock
    private FileInputStream fis;

    @InjectMocks
    private FileUtils target;

    @Before
    public void setUp() throws Exception {
        PowerMockito.spy(FileUtils.class);

        PowerMockito.whenNew(File.class).withAnyArguments().thenReturn(mockedFile);

        PowerMockito.whenNew(ObjectInputStream.class).withAnyArguments().thenReturn(ois);
        PowerMockito.whenNew(FileInputStream.class).withAnyArguments().thenReturn(fis);

        PowerMockito.whenNew(ObjectOutputStream.class).withAnyArguments().thenReturn(oos);
        PowerMockito.whenNew(FileOutputStream.class).withAnyArguments().thenReturn(fos);

        PowerMockito.whenNew(Paths.class).withAnyArguments().thenReturn(paths);

        Mockito.when(mockedFile.getAbsolutePath()).thenReturn("No path was given.");
    }

    @Test
    public void saveCharacterToFile() {
        final Character character = new Character("Dummy", CharacterClassEnum.JAVA_PROGRAMMER);

        final String uuid = target.saveCharacterToFile(character);

        assertThat(uuid).isNotNull();
    }

    @Test(expected = EndGameException.class)
    public void saveCharacterToFileMustThrowException() throws Exception {
        final Character character = new Character("Dummy", CharacterClassEnum.JAVA_PROGRAMMER);

        PowerMockito.whenNew(ObjectOutputStream.class).withAnyArguments()
                .thenThrow(new FileNotFoundException("Forced FileNotFoundException"));

        final String uuid = target.saveCharacterToFile(character);

        assertThat(uuid).isNotNull();
    }

    @Test
    public void readCharacterFromFile() throws IOException, ClassNotFoundException {
        final String uuid = "fae7c855-e9c7-49fb-b920-764edbf79891";
        final Character mockCharacter = new Character("Dummy", CharacterClassEnum.JAVASCRIPT_PROGRAMMER);

        Mockito.when(ois.readObject()).thenReturn(mockCharacter);

        final Character character = target.readCharacterFromFile(uuid);

        assertThat(character)
                .isNotNull()
                .isInstanceOf(Character.class)
                .extracting("name")
                .contains("Dummy");
    }

    @Test(expected = EndGameException.class)
    public void readCharacterFromFileMustThrowException() throws IOException, ClassNotFoundException {
        final String uuid = "fae7c855-e9c7-49fb-b920-764edbf79891";

        Mockito.when(ois.readObject()).thenThrow(new NullPointerException());

        final Character character = target.readCharacterFromFile(uuid);
    }

    @Test
    public void waitSecondsMustPrintEmptyLineWhenExceptionOccurs() throws InterruptedException {
        spy(Thread.class);
        doThrow(new InterruptedException()).when(Thread.class);
        Thread.sleep(anyLong());

        target.waitSeconds(1);
    }

    @Test
    public void waitSecondsMustWorks() {
        target.waitSeconds(1);
    }
}