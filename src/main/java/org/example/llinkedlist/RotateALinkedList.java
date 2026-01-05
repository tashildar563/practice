package org.example.llinkedlist;

import java.util.LinkedList;
import org.example.Node;
import org.example.Solution;

public class RotateALinkedList implements Solution {
    @Override
    public void logic() {
        Node head = new Node(1);
        add(head,2);
        add(head,3);
        LinkedList linkedList = new LinkedList();
        int rotateBy =1;
        Node rotatedList = rotateLinkedListBykPosition(head,rotateBy);
        System.out.println("Rotate list by "+rotateBy);
        while(rotatedList!=null){
            System.out.println(" >> "+rotatedList.data);
            rotatedList = rotatedList.next;
        }


    }

    private Node rotateLinkedListBykPosition(Node head, int rotateBy) {
        if (rotateBy == 0 || head == null)
            return head;
        Node current = head;
        int len = 1;
        while(current.next!=null){
            len+=1;
            current = current.next;
        }
        int k = rotateBy % len;
        if(k==0){
            return head;
        }
        current.next = head;
        current = head;
        for(int i=0;i<len-k-1;i++){
            current = current.next;
        }
        head = current.next;
        current.next = null;
        return head;

    }

    public Node rotete(Node head , int by){
      if(by==0 || head == null){
        return head;
      }
      Node current = head;
      int len = 1;
      while(current!=null){
        len++;
        current = current.next;
      }
      by = by%len;
      if(by==0){
        return head;
      }
      current.next = head;
      current = head;
      for(int j=0; j<by ; j++){
        current = current.next;
      }
      head = current.next;
      current.next = null;
      return head;
    }

    private void add(Node head, int i) {
        if(head.next!=null){
            add(head.next,i);
        }else{
            head.next = new Node(i);
        }
    }

    @Override
    public String description() {
        return "12. Rotate A Linked List";
    }

    @Override
    public String problemStatement() {
        return "Given the head of a singly linked list and an integer k, rotate the list to the left by k positions and return the updated head.";
    }
}
