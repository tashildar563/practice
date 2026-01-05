package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Sequence No :");
    int n = sc.nextInt();
    Solution solution = SolutionFactory.createSolution(n);

    System.out.println("================================= " + solution.description() + " START=================================");
    System.out.println(solution.problemStatement());
    System.out.println();
    solution.logic();
    System.out.println();
    System.out.println("================================= " + solution.description() + " END=================================");
  }
}