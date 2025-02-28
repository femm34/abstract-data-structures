package com.fecd;

public class LinkedList<T> {
    private ListNode<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void add(T value) {
        ListNode<T> newNode = new ListNode<T>(value);
        if (this.head == null) {
            head = newNode;
        } else {
            ListNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }


    public void printList() {
        ListNode<T> current = head;
        while (current.next != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
