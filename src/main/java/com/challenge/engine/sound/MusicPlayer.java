package com.challenge.engine.sound;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

public class MusicPlayer {


    public void makeSomeNoise() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();

            final File file = new File(Objects.requireNonNull(classLoader.getResource("file.wav")).getFile());
            final FileInputStream fileInputStream = new FileInputStream(file);

            try (AudioStream audioStream = new AudioStream(fileInputStream)) {
                AudioPlayer.player.start(audioStream);
            }
    } catch(Exception ex) {
            System.err.println("Error playing sound!");
        }
    }
}
