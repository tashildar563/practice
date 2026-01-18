package org.example.array.YEAR2025;

import org.example.Solution;

public class PringOddEvenUsingTwoThreads implements Solution {
  public static class Printer{
    private int number = 1;
    private final int max=20;

    public synchronized void printOdd(){
      while(number<=max){
        while(number%2==0){
          try{
            wait();
          }catch (InterruptedException e){
            System.out.println("Exceptions odd");
          }
        }
        if(number<=max){
          System.out.println("Odd  >>"+ number);
          number++;
          notify();
        }

      }
    }
    public synchronized void printEven(){
      while(number<=max){
        while(number%2!=0){
          try{
            wait();
          }catch (InterruptedException e){
            System.out.println("Exception even");
          }
        }
        if(number<=max){
          System.out.println(" Even >> "+number);
          number++;
          notify();
        }
      }
    }
  }

  @Override
  public void logic() {
    Printer printer = new Printer();
    Thread t1 = new Thread(()->printer.printOdd());
    Thread t2 = new Thread(()->printer.printEven());
    t1.start();
    t2.start();

  }

  @Override
  public String description() {
    return "48";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
