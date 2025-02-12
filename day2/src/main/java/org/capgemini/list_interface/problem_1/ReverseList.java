package org.capgemini.list_interface.problem_1;

import java.util.List;

public class ReverseList {
    static <T> void reverseArrayList(List<T> list){
        int s = 0;
        int e = list.size()-1;
        while(s<e){
            T temp = list.get(s);
            list.set(s++,list.get(e));
            list.set(e--,temp);
        }
    }

    static <T> Node<T> reverseLinkedList(Node<T> list){
        Node<T> curr = copyLinkedList(list);
        Node<T> prev = null;

        while(curr != null){
            Node<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static <T> Node<T> copyLinkedList(Node<T> list){
        if(list == null) return null;

        Node<T> newNode = new Node<>(list.val);
        list = list.next;
        Node<T> temp = newNode;
        while(list != null){
            temp.next = new Node<>(list.val);
            temp = temp.next;
            list = list.next;
        }

        return newNode;
    }
}
