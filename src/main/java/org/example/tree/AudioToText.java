//package org.example.tree;
//
//import java.io.BufferedInputStream;
//import java.io.FileInputStream;
//import java.io.IOException;
//import javax.sound.sampled.AudioFormat;
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.UnsupportedAudioFileException;
//import org.json.JSONObject;
//import org.vosk.Model;
//import org.vosk.Recognizer;
//
//public class AudioToText {
//
//  public static void main(String[] args) throws IOException, UnsupportedAudioFileException {
//
//    Model model = new Model("model/vosk-model-small-en-us-0.15");
//
//    // Wrap FileInputStream in BufferedInputStream
//    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("recording.wav"));
//    AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
//
//    AudioFormat format = ais.getFormat();
//
//    if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
//      throw new IllegalArgumentException("Audio must be WAV PCM 16-bit.");
//    }
//
//    Recognizer recognizer = new Recognizer(model, (int) format.getSampleRate());
//
//    byte[] buffer = new byte[4096];
//    int n;
//
//    System.out.println("Transcribing...\n");
//
//    while ((n = ais.read(buffer)) >= 0) {
//      if (recognizer.acceptWaveForm(buffer, n)) {
//        String result = recognizer.getResult();
//        JSONObject json = new JSONObject(result);
//        System.out.println(json.getString("text"));
//      }
//    }
//
//    String finalResult = recognizer.getFinalResult();
//    JSONObject jsonFinal = new JSONObject(finalResult);
//    System.out.println("\nFINAL TEXT:");
//    System.out.println(jsonFinal.getString("text"));
//  }
//
//}
