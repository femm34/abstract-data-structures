package com.fecd;

public class ListNode<T> {
    T val;
    ListNode<T> next;

    public ListNode(T x) {
        val = x;
        this.next = null;
    }
}
