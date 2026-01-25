package org.example;


import java.awt.Desktop;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {

//    Scanner sc = new Scanner(System.in);
//    System.out.println("Enter Sequence No :");
//    int n = sc.nextInt();
//    Solution solution = SolutionFactory.createSolution(n);
//
//    System.out.println("================================= " + solution.description() + " START=================================");
//    System.out.println(solution.problemStatement());
//    System.out.println();
//    solution.logic();
//    System.out.println();
//    System.out.println("================================= " + solution.description() + " END=================================");
    Scanner sc = new Scanner(System.in);
int i=1;
//    while (i>=0) {
      try {
        System.out.println("Enter Sequence No :");
        int n = sc.nextInt();

        Solution solution = SolutionFactory.createSolution(n);

        // Capture console output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream oldOut = System.out;

        System.setOut(ps);   // redirect output

        // ===== Existing code (UNCHANGED) =====
        System.out.println("================================= "
            + solution.description()
            + " START=================================");
        System.out.println(solution.problemStatement());
        System.out.println();
        solution.logic();
        System.out.println();
        System.out.println("================================= "
            + solution.description()
            + " END=================================");
        // =====================================

        System.out.flush();
        System.setOut(oldOut); // restore console

        String consoleOutput = baos.toString();

        // Convert console output to HTML
        String html = "<html><head><title>Output</title>"
            + "<style>"
            + "body{font-family:monospace;} "
            + "pre{background:#f4f4f4;padding:15px;}"
            + "</style></head><body>"
            + "<pre>" + escapeHtml(consoleOutput) + "</pre>"
            + "</body></html>";

        // Write to file
        File file = new File("output.html");
        FileWriter writer = new FileWriter(file);
        writer.write(html);
        writer.close();
        Desktop.getDesktop().browse(file.toURI());
i--;
      } catch (Exception e) {
        e.printStackTrace();
      }
//    }
    sc.close();
  }
  private static String escapeHtml(String text) {
    return text.replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;");
  }
}