package org.example;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/** App */
public class App extends TGBot {

  public static void main(String[] args) {
    setToken("7869941210:AAE8-IISSpNyrwJIZXf-lINi3jZ9bNAO5uU");
    start();
  }

  @Command("start")
  String startCommand() {
    return "Привет";
  }

  @Command("square")
  String sum(String letter, int a, int b) {
    return ((letter + "  ").repeat(a) + "\n").repeat(b);
  }

  @Command("play")
  String playSomeSound() {
    playSound("beep-02.wav");

    return "played";
  }

  static void playSound(String filePath) {

    try {
      File soundFile = new File(filePath);
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
      Clip clip = AudioSystem.getClip();
      clip.open(audioStream);
      clip.start();

      // Ожидаем завершения воспроизведения
      Thread.sleep(clip.getMicrosecondLength() / 1000);

      clip.close();
    } catch (UnsupportedAudioFileException
        | IOException
        | LineUnavailableException
        | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
