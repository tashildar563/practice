package org.example.llinkedlist;

import org.example.Node;
import org.example.Solution;

public class ReverseTheLinkedList implements Solution {
    @Override
    public void logic() {
        Node head = new Node(1);
        add(head, 2);
        add(head, 3);
        add(head, 4);
        Node reverseList = reverseTheLinkedList(head);
        System.out.println("Reverse List : ");
        while(reverseList!=null){
            System.out.print(reverseList.data + " >> ");
            reverseList = reverseList.next;
        }
        System.out.println();

    }

    private Node reverseTheLinkedList(Node head) {
        Node current = head, prev = null, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private void add(Node head, int i) {
        if (head.next != null) {
            add(head.next, i);
        } else {
            head.next = new Node(i);
        }
    }

    @Override
    public String description() {
        return "11. Reverse The Linked List";
    }

    @Override
    public String problemStatement() {
        return "Given a linked list, we have to reverse the linked list by changing the links between nodes.";
    }
}
