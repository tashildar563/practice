package org.example.array.jan2026;

import org.example.Solution;

public class ThreadStateImplementation implements Solution, Runnable {
  public static Thread mainThread;
  public static ThreadStateImplementation threadStateImplementation;

  @Override
  public void logic() {
    threadStateImplementation = new ThreadStateImplementation();
    mainThread = new Thread(threadStateImplementation);
    System.out.println("State after creating main thread : " + mainThread.getState());
    mainThread.start();
    try {
      mainThread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("STate after starting main thread : "+mainThread.getState());

  }

  @Override
  public String description() {
    return "";
  }

  @Override
  public String problemStatement() {
    return "";
  }

  @Override
  public String getToughness() {
    return "Medium";
  }

  @Override
  public void run() {
    TicketBooking ticketBooking = new TicketBooking();
    Thread bookingThread = new Thread(ticketBooking);
    System.out.println("State after creating booking thread : "+bookingThread.getState());
    bookingThread.start();
    System.out.println("State after starting booking thread : "+bookingThread.getState());
    try {
      Thread.sleep(100);
    }catch(InterruptedException e){
      e.printStackTrace();
    }
    System.out.println("State after boolking thread finishes: "+ bookingThread.getState());

  }

  class TicketBooking implements Runnable{

    @Override
    public void run() {
      try{
        Thread.sleep(200);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println("State fo booking thread while mainThread is waiting : "+ThreadStateImplementation.mainThread.getState());
      try {
        Thread.sleep(100);
      }catch (InterruptedException e){
        e.printStackTrace();
      }
    }
  }

}
