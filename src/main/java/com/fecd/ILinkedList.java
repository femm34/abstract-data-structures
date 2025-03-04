package com.fecd;

public interface ILinkedList<T> {
    void insertNodeAtTheBeginning(T value);

    void addNodeAtTheEnd(T value);

    void removeTheFirst();

    void removeTheLast();

    Object removeValue(T value);

    Object get(T value);

    void printList();

}
