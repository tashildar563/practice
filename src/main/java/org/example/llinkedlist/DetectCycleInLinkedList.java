package org.example.llinkedlist;

import org.example.Solution;

public class DetectCycleInLinkedList implements Solution {
  class Node{
    private int data;
    private Node next;
    public Node(int data){
      this.data = data;
    }
  }

  @Override
  public void logic() {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = head.next;
    boolean isCycle = cycleDetected(head);
    System.out.println("Cycle Detected :"+isCycle);

  }

  private boolean cycleDetected(Node head) {
    Node slow=head;
    Node fast =head;
    while(slow!=null && fast !=null && fast.next!=null){
      slow = slow.next;
      fast = fast.next.next;
      if(fast==slow){
        return true;
      }
    }
    return false;
  }

  @Override
  public String description() {
    return "52. Cycle Detection";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
