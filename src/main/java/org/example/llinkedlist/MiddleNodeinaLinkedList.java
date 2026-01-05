package org.example.llinkedlist;

import org.example.Solution;

public class MiddleNodeinaLinkedList implements Solution {

  public class Node{
    int data;
    Node next;
    Node(int x){
      this.data=x;
      this.next=null;
    }
  }

  @Override
  public void logic() {
    Node node = new Node(1);
    node.next = new Node(2);
    node.next.next = new Node(3);
    node.next.next.next = new Node(4);
    node.next.next.next.next = new Node(5);


    Node slowPtr = node;
    Node fastPtr = node;
    while(fastPtr!=null && fastPtr.next!=null){
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
    }
    System.out.println("Middle node :" + slowPtr.data);
  }

  public int getLength(Node node){
    int length =0;
    while(node!=null){
      node = node.next;
      length++;
    }
    return length;
  }

  @Override
  public String description() {
    return "33. Middle Node in a Linked List.";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
