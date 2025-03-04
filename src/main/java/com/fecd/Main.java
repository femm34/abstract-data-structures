package com.fecd;

import java.util.List;

public class Main {

    public static void iterateList(List<Integer> arreglo, int indice) {
        if (indice == arreglo.size()) {
            return;
        }
        System.out.println(arreglo.get(indice));
        iterateList(arreglo, indice + 1);
    }

    public static void main(String[] args) {
        var linkedList = LinkedList.LinkedListOf("arturo", "iban", "luis", "yayi", 123, true, false);
        linkedList.printList();

        linkedList.removeValue("arturo");
        linkedList.printList();

    }
}