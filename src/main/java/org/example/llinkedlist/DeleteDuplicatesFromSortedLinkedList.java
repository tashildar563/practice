package org.example.llinkedlist;

import java.util.HashMap;
import java.util.List;
import org.example.Solution;

public class DeleteDuplicatesFromSortedLinkedList implements Solution {

  @Override
  public void logic() {
    int[] arr = {1, 2, 3, 3, 4, 4, 5};
    ListNode first = new ListNode(1);
    first.next = new ListNode(2);
    first.next.next = new ListNode(2);
    first.next.next.next = new ListNode(3);
    first.next.next.next.next = new ListNode(4);
    first.next.next.next.next.next = new ListNode(4);
    first.next.next.next.next.next.next = new ListNode(5);

    ListNode result = deleteDuplicates(first);

    while (result != null) {
      System.out.print(" >> " + result.val);
      result = result.next;
    }

  }
  public ListNode deleteDuplicate(ListNode head){
    if(head==null) return head;
    ListNode temp=head;
    while(temp!=null){
      if(temp.next != null && temp.val == temp.next.val){
        temp.next = temp.next.next;
      }else{
        temp = temp.next;
      }
    }

    return head;
  }

  private ListNode deleteDuplicates(ListNode head) {
    if(head == null){
      return head;
    }

    ListNode temp = head;
    while(temp!=null){
      if(temp.next !=null && temp.val == temp.next.val){
        temp.next = temp.next.next;
      }else{
        temp = temp.next;
      }
    }
    return head;
  }

  public ListNode deleteNode(int key, ListNode first) {
    if (first == null) {
      return null;
    }

    if (first.val == key) {
      return first.next;
    }
    ListNode current = first;
    ListNode prev = null;

    while (current != null && current.val != key) {
      prev = current;
      current = current.next;
    }
    if (current == null) {
      return first;
    }
    prev.next = current.next;
    return first;
  }

  @Override
  public String description() {
    return "29";
  }

  @Override
  public String problemStatement() {
    return "";
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
