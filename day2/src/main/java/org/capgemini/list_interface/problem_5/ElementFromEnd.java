package org.capgemini.list_interface.problem_5;

import java.util.LinkedList;

public class ElementFromEnd {
    // Function to find the Nth element from the end
    public static <T> T findNthFromEnd(LinkedList<T> list, int N) {
        // Two-pointer approach
        var first = list.listIterator(); // First pointer
        var second = list.listIterator(); // Second pointer

        // Move the first pointer N steps ahead
        for (int i = 0; i < N; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException("N is larger than the list size");
            }
            first.next();
        }

        // Move both pointers one step at a time until first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        // The second pointer now points to the Nth element from the end
        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2;
        try {
            System.out.println("The " + N + "th element from the end is: " + findNthFromEnd(list, N));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
