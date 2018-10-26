package com.challenge.engine.sound;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;


public class Music {
    public static void main(String[] argv) throws Exception {
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();

        // From file
        InputStream input = new BufferedInputStream(new FileInputStream(Music.class.getClassLoader().getResource("Toxicity.mid").getFile()));

//        // From URL
//        input = new BufferedInputStream(new URL("http://hostname/rmffile").openStream());

        sequencer.setSequence(input);

        // Start playing
        sequencer.start();
    }
}
