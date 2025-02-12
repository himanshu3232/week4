package org.capgemini.list_interface.problem_1;

//Class representing a linked list
public class Node<T> {

    //next node
    Node<T> next;

    //dynamic value T
    T val;

    Node(){}
    Node(T val){
        this.val = val;
    }
    Node(T val, Node<T> next){
        this.next = (next != null) ? new Node<>(next.val,next.next) : null;
        this.val = val;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        Node <T> temp = this;
        while(temp != null){
            sb.append(temp.val).append("->");
            temp = temp.next;
        }
        sb.append("END");
        return sb.toString();
    }
}

