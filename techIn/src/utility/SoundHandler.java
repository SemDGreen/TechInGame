package utility;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundHandler {

    private static Clip clip;

    private SoundHandler() {

    }


    public static void playSound(String wavFilePath) {

        try {

            File file = new File(wavFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(SoundHandler.class.getClassLoader().getResourceAsStream(wavFilePath));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (IOException | UnsupportedAudioFileException | NullPointerException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void stopSound() {
        clip.stop();
    }

    public static Clip getClip() {
        return clip;
    }
}
