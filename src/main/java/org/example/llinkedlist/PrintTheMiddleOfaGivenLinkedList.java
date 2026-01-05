package org.example.llinkedlist;

import org.example.Node;
import org.example.Solution;

public class PrintTheMiddleOfaGivenLinkedList implements Solution {
    @Override
    public void logic() {
        Node head = new Node(1);
        add(head,2);
        add(head,3);
        add(head,4);
        Node n = head;
        int l = 0;
        while(n!=null){
            System.out.print(n.data + " >>");
            n=n.next;
            l++;
        }
        System.out.println();
        System.out.println("length : " + l);
        int mid = 0;
        if(l%2==1){
            mid = (l+1)/2;
        }else {
            mid = l/2;
            mid++;
        }
        Node middleNode = null;
        n=head;
        while(mid!=0){
            middleNode = n;
            n = n.next;
            mid--;
        }

        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
          fast = fast.next.next;
          slow = slow.next;
        }
        System.out.println("middle node : "+ slow.data);
        System.out.println("middle node : "+ middleNode.data);
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
        return "10. Middle Node in a Linked List";
    }

    @Override
    public String problemStatement() {
        return "Given the head of singly linked list, find middle node of the linked list.\n" +
                "\n" +
                "If the number of nodes is odd, return the middle node.\n" +
                "If the number of nodes is even, there are two middle nodes, so return the second middle node.";
    }
}
