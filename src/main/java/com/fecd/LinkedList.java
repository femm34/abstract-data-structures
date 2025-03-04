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
        if (head == null) {
            return;
        }
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public void removeLast() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            ListNode<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }


    public Object remove(T value) {
        if (head == null) {
            return "List is empty";
        }

        if (head.val.equals(value)) {
            head = head.next;
            return value;
        }

        ListNode<T> currentNode = head;
        while(currentNode.next != null){
            if(currentNode.next.val == value){
                ListNode<T> nodeToRemove = currentNode.next;
                currentNode.next = currentNode.next.next;
                return nodeToRemove.val;
            }
            currentNode = currentNode.next;
        }

        return "No elements found";
    }


    public Object get(T value) {
        if (head == null) {
            return "Emptu list";
        }
        if (head.val == value) {
            return head.val;
        }
        ListNode<T> current = head;
        while (current.next != null) {
            if (current.next == value) {
                return current.next.val;
            }
            current = current.next;
        }
        if (current.val == value){
            return current.val;
        }
        return "No elements found";
    }

}
