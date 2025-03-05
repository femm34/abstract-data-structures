package com.fecd;

public class Main {
    public static void main(String[] args) {
        var linkedList = LinkedList.LinkedListOf("Elia");
        linkedList.printList();
        System.out.println(linkedList.nodeAt(0));
        System.out.println(linkedList.nodeAt(1));
    }
}