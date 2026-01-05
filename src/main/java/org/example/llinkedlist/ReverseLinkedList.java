package org.example.llinkedlist;

import java.util.ArrayList;
import java.util.List;
import org.example.Solution;
import org.example.llinkedlist.MiddleNodeinaLinkedList.Node;

public class ReverseLinkedList implements Solution {
  public class Node {
    int data;
    Node next;
    Node(int x){
      this.data = x;
      this.next = null;
    }
  }

  @Override
  public void logic() {
    Node node = new Node(1);
    node.next = new Node(2);
    node.next.next = new Node(3);
    node.next.next.next = new Node(4);
    node.next.next.next.next = new Node(5);

    Node prev = null;
    Node curr = node;
    Node next = null;
    while(curr!=null){
      next = curr.next;
      curr.next =prev;
      prev = curr;
      curr = next;
    }
    while(prev!=null){
      System.out.print(" >> "+prev.data);
      prev = prev.next;
    }

  }

  @Override
  public String description() {
    return "34. Reverse Linked List";
  }

  @Override
  public String problemStatement() {
    return "";
  }
}
