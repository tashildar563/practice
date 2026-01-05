//package org.example.tree;
//
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import java.awt.Toolkit;
//import java.awt.datatransfer.Clipboard;
//import java.awt.datatransfer.StringSelection;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import javax.sound.sampled.AudioFileFormat;
//import javax.sound.sampled.AudioFormat;
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.DataLine;
//import javax.sound.sampled.TargetDataLine;
//import org.json.JSONObject;
//import org.vosk.Model;
//import org.vosk.Recognizer;
//
//public class MicRecorder {
//  private static TargetDataLine line;
//
//  public static void main(String[] args) {
//    try {
//
//      // Load Vosk model (folder path)
//      Model model = new Model("model/vosk-model-small-en-us-0.15");  // <-- your model folder
//      Recognizer recognizer = new Recognizer(model, 16000);
//
//      AudioFormat format = getAudioFormat();
//      DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
//
//      if (!AudioSystem.isLineSupported(info)) {
//        System.out.println("Microphone not supported");
//        return;
//      }
//
//      line = (TargetDataLine) AudioSystem.getLine(info);
//      line.open(format);
//      line.start();
//
//      System.out.println("🎤 Listening... Press ENTER to stop.");
//
//      Thread speechThread = new Thread(() -> {
//        byte[] buffer = new byte[4096];
//
//        while (line.isOpen()) {
//          int bytesRead = line.read(buffer, 0, buffer.length);
//          if (bytesRead > 0) {
//
//            if (recognizer.acceptWaveForm(buffer, bytesRead)) {
//              // Final result chunk
//              System.out.println("➡ Result: " + recognizer.getResult());
//              // Parse JSON properly
//              JsonObject obj = JsonParser.parseString(recognizer.getResult()).getAsJsonObject();
//              String text = obj.get("text").getAsString();
//
//              if (!text.isEmpty()) {
//                copyToClipboard(text);
//              }
//            } else {
//              // Partial result
//              System.out.println("↪ Partial: " + recognizer.getPartialResult());
//            }
//          }
//        }
//
//        // Print final recognition result
//        System.out.println("Final: " + recognizer.getFinalResult());
//
//      });
//
//      speechThread.start();
//
//      // Wait for ENTER
//      System.in.read();
//
//      line.stop();
//      line.close();
//      System.out.println("Stopped.");
//
//    } catch (Exception ex) {
//      ex.printStackTrace();
//    }
//  }
//
//  private static AudioFormat getAudioFormat() {
//    return new AudioFormat(16000, 16, 1, true, false);
//  }
//  private static void copyToClipboard(String text) {
//    try {
//      StringSelection selection = new StringSelection(text);
//      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//      clipboard.setContents(selection, null);
//      System.out.println("📋 Copied to clipboard: " + text);
//    } catch (Exception e) {
//      e.printStackTrace();
//      System.out.println("⚠ Clipboard failed");
//    }
//  }
//
//}
//
