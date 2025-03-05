package com.fecd;

import com.fecd.Exceptions.EmptyLinkedListException;
import com.fecd.Exceptions.IndexOutOfRangeException;
import com.fecd.Exceptions.NoElementsFoundException;

import java.util.Objects;
import java.util.function.Predicate;

public class LinkedList<T> implements ILinkedList<T> {
    private ListNode<T> head;
    private Long size = 0L;

    public LinkedList() {
        this.head = null;
    }

    private boolean actualIsNull(ListNode<T> listNode) {
        Predicate<ListNode<T>> actual = Objects::isNull;
        return actual.test(listNode);
    }

    private boolean hasOnlyOneNode(ListNode<T> listNode) {
        Predicate<ListNode<T>> hasOnlyOneElement = node -> node.next == null;
        return hasOnlyOneElement.test(listNode);
    }

    private boolean hasMoreNodesAfterTheCurrentOne(ListNode<T> listNode) {
        Predicate<ListNode<T>> hasMoreNodesAfterTheCurrentO = node -> node.next != null;
        return hasMoreNodesAfterTheCurrentO.test(listNode);
    }

    private ListNode<T> buildNodeList(T value) {
        return new ListNode<>(value);
    }

    private void decrementSize() {
        size--;
    }

    private void incrementSize() {
        size++;
    }

    @Override
    public Long size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void insertNodeAtTheBeginning(T value) {
        ListNode<T> newNode = buildNodeList(value);
        newNode.next = head;
        head = newNode;
        incrementSize();
    } // Finished

    @Override
    public void addNodeAtTheEnd(T value) {
        ListNode<T> newNode = buildNodeList(value);
        if (isEmpty()) {
            head = newNode;
            incrementSize();
        } else {
            ListNode<T> current = head;
            while (hasMoreNodesAfterTheCurrentOne(current)) {
                current = current.next;
            }
            current.next = newNode;
            incrementSize();
        }
    } // Finished


    @Override
    public void printList() {
        ListNode<T> current = head;
        if (isEmpty()) {
            return;
        }
        while (!actualIsNull(current)) {
            System.out.print(current.val);
            if (hasMoreNodesAfterTheCurrentOne(current)) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    } // Finished

    @Override
    public void removeTheLast() {
        if (isEmpty()) {
            return;
        }
        if (hasOnlyOneNode(head)) {
            head = null;
            decrementSize();
        } else {
            ListNode<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
            decrementSize();
        }
    } // Finished

    @Override
    public void removeTheFirst() {
        if (!isEmpty()) {
            head = (hasMoreNodesAfterTheCurrentOne(head)) ? head.next : null;
            decrementSize();
        }
    } // Finished


    @Override
    public Object removeValue(T value) {
        if (isEmpty()) {
            throw new EmptyLinkedListException("List is empty");
        } else if (head.val.equals(value)) {
            head = head.next;
            decrementSize();
            return value;
        }
        ListNode<T> currentNode = head;
        while (hasMoreNodesAfterTheCurrentOne(currentNode)) {
            if (currentNode.next.val == value) {
                ListNode<T> nodeToRemove = currentNode.next;
                currentNode.next = currentNode.next.next;
                decrementSize();
                return nodeToRemove.val;
            }
            currentNode = currentNode.next;
        }
        throw new NoElementsFoundException("No elements found");
    } // Finished

    @Override
    public Object nodeAt(int index) {
        if (index < 0) {
            throw new IndexOutOfRangeException("Index should be a positive number");
        }
        ListNode<T> current = head;
        int counter = 0;

        while (current != null) {
            if (index == counter) {
                return current.val;
            }
            current = current.next;
            counter++;
        }
        throw new IndexOutOfRangeException("Index out of range");
    }


    @Override
    public Object get(T value) {
        if (head == null) {
            throw new EmptyLinkedListException("List is empty");
        }
        if (head.val == value) {
            return head.val;
        }
        ListNode<T> current = head;
        while (hasMoreNodesAfterTheCurrentOne(current)) {
            if (current.next.equals(value)) {
                return current.next.val;
            }
            current = current.next;
        }
        if (current.val.equals(value)) {
            return current.val;
        }
        throw new NoElementsFoundException("No elements found");
    }

    @SafeVarargs
    public static <T> LinkedList<T> LinkedListOf(T... values) {
        LinkedList<T> list = new LinkedList<>();
        for (T value : values) {
            list.addNodeAtTheEnd(value);
        }
        return list;
    }

}
