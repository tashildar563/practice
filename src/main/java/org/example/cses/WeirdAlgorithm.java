package org.example.cses;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.example.Solution;

public class WeirdAlgorithm implements Solution {

  @Override
  public void logic() {
//    int i = 138367;
//    algorithm(i);
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int s = input.nextInt();
    Map<Integer,Integer> map = new HashMap<>();
//    for(int i=0;i<parts.length;i++){
//      map.put(Integer.parseInt(parts[i]),0);
//    }
    while(n>0){
      if(map.get(n)==null){
        System.out.print(n);
        break;
      }
      n--;
    }
  }

  private void algorithm(long i) {
    System.out.print(" "+i+" ");
    if(i<=1){
      return;
    }
    if(i%2==0){
      divideByTwo(i);
    }else{
      multiplyByThreeAndAddOne(i);
    }
  }

  private void multiplyByThreeAndAddOne(long i) {
    if(i<=1){
      return;
    }
    i = (i*3)+1;
    algorithm(i);
  }

  private void divideByTwo(long i) {
    i=i/2;
    algorithm(i);
  }

  @Override
  public String description() {
    return "56";
  }

  @Override
  public String problemStatement() {
    return "Time limit: 1.00 s\n"
        + "Memory limit: 512 MB\n"
        + "\n"
        + "Consider an algorithm that takes as input a positive integer n. If n is even, the algorithm divides it by two, and if n is odd, the algorithm multiplies it by three and adds one. The algorithm repeats this, until n is one. For example, the sequence for n=3 is as follows:\n"
        + "$$ 3 \\rightarrow 10 \\rightarrow 5 \\rightarrow 16 \\rightarrow 8 \\rightarrow 4 \\rightarrow 2 \\rightarrow 1$$\n"
        + "Your task is to simulate the execution of the algorithm for a given value of n.\n"
        + "Input\n"
        + "The only input line contains an integer n.\n"
        + "Output\n"
        + "Print a line that contains all values of n during the algorithm.\n"
        + "Constraints\n"
        + "\n"
        + "1 \\le n \\le 10^6\n"
        + "\n"
        + "Example\n"
        + "Input:\n"
        + "3\n"
        + "\n"
        + "Output:\n"
        + "3 10 5 16 8 4 2 1";
  }
}
