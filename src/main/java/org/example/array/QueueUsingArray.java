package org.example.array;

import org.example.Solution;

public class QueueUsingArray implements Solution {

  @Override
  public void logic() {
    CustomQueue queue = new CustomQueue(3);
    queue.enque(1);
    queue.enque(2);
    queue.enque(3);
    while(queue.isPresent()){
      System.out.println(queue.deque() + "  ");
    }
  }

  @Override
  public String description() {
    return "";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
