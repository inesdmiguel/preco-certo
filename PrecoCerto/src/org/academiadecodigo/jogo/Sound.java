package org.academiadecodigo.jogo;
import javax.sound.sampled.*;
import java.net.URL;

public class Sound {
    //Methods
    public static void main(String[] args) {
        Sound.playSound("/Sound/game_intro.wav",7000);
        Sound.playSound("/Sound/guessed_right.wav", 2200);
        Sound.playSound("/Sound/guessed_wrong.wav", 1000);
        Sound.playSound("/Sound/espetaculo.wav", 3000);

    }

    public static void playSound(String filePath, int durationMillis) {
        try {
            URL url = Sound.class.getResource(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);

            clip.open(audioInputStream);
            clip.start();

            int loopCount = (int) ((durationMillis * clip.getFormat().getFrameRate()) / clip.getFrameLength()) + 1;
            clip.loop(loopCount);

            Thread.sleep(durationMillis);

            clip.stop();
            clip.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
