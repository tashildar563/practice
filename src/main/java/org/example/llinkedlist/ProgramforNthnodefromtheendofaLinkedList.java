package org.example.llinkedlist;

import org.example.Node;
import org.example.Solution;

public class ProgramforNthnodefromtheendofaLinkedList implements Solution {

  @Override
  public void logic() {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    int n =4;
    Node trailingNode = head;
    Node leadingNode = head;

    for(int i=1;i<n;i++){
      leadingNode = leadingNode.next;
      if(leadingNode==null){
        System.out.println("No nth node from end");
        return;
      }
    }
    while(leadingNode.next!=null){
      trailingNode = trailingNode.next;
      leadingNode = leadingNode.next;
    }
    System.out.println("nth Node from the end is: "+ trailingNode.data);
   }

  @Override
  public String description() {
    return "35.";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
