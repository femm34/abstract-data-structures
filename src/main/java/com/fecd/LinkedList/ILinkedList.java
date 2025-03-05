package com.fecd.LinkedList;

public interface ILinkedList<T> {
    void insertNodeAtTheBeginning(T value);

    void addNodeAtTheEnd(T value);

    void removeTheFirst();

    void removeTheLast();

    Object removeValue(T value);

    Object get(T value);

    Object nodeAt(int value);

    void printList();

    boolean isEmpty();

    Long size();
}
