package org.example.llinkedlist;

import java.util.ArrayList;
import java.util.List;
import org.example.Node;
import org.example.Solution;

public class RemoveDuplicateFromLinkedList2 implements Solution {

  @Override
  public void logic() {
    int arr[]={1,2,3,3,4,4,5};
    Node node = new Node(arr[0]);
    for(int i=1;i<arr.length;i++){
      addTo(node,arr[i]);
    }
    node = deleteDuplicates(node);
    System.out.println("Output : ");
    while(node!=null){
      System.out.print(" >> "+ node.data);
      node = node.next;
    }
  }

  private Node deleteDuplicates(Node node) {
    if(node==null || node.next==null){
      return node;
    }
    if(node.data != node.next.data){
      node.next = deleteDuplicates(node.next);
      return node;
    }

    int data = node.data;
    while(node!=null && node.data == data){
      node = node.next;
    }
    return deleteDuplicates(node);
  }

  private void addTo(Node node, int i) {
    if(node.next==null){
      node.next = new Node(i);
      return;
    }
    addTo(node.next,i);
  }

  @Override
  public String description() {
    return "37";
  }

  @Override
  public String problemStatement() {
    return "Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.\n"
        + "\n"
        + " \n"
        + "\n"
        + "Example 1:\n"
        + "\n"
        + "\n"
        + "Input: head = [1,2,3,3,4,4,5]\n"
        + "Output: [1,2,5]";
  }
}
