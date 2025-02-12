package org.capgemini.list_interface.problem_1;

import java.util.ArrayList;
import java.util.List;

//Main class to run code
public class Main {
    public static void main(String[] args) {
        //ArrayList example
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5));

        //before
        System.out.println(list);

        //reverse list
        ReverseList.reverseArrayList(list);

        //after
        System.out.println(list);


        //LinkedList example
        Node<String> head = new Node<String>("a",
                new Node<>("b",
                        new Node<>("c",
                                new Node<>("d",
                                        new Node<>("e", null)))));

        //before
        System.out.println(head);

        //reverse list
        Node<String> reversedNode = ReverseList.reverseLinkedList(head);

        //after
        System.out.println(reversedNode);

        //original object is not mutated
        System.out.println(head);



    }
}

