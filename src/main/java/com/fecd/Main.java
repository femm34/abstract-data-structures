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
        LinkedList<Object> linkedList = new LinkedList<>();

        linkedList.add("asdas");
        linkedList.add(12312);
        linkedList.add("99999");
//        linkedList.add("te amo Elia");
        linkedList.printList();
//        linkedList.removeLast();
        linkedList.printList();
        System.out.println("element found:");
        System.out.println(linkedList.get(12312));;
        linkedList.printList();;
        System.out.println("deleted value: " + linkedList.remove("99999"));
        linkedList.printList();

//        linkedList.printList();
//        linkedList.removeLast();
//        linkedList.printList();


//        List<Integer> list = List.of(1, 2, 3, 4, 5);
//
//        iterateList(list, 0);
    }
}