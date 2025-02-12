package org.capgemini.set_interface.problem_2;

import java.util.*;

public class SetOperations {
    public static void main(String[] args) {
        // Define two sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Compute union of two sets
        Set<Integer> unionSet = new HashSet<>(set1); // Copy set1 elements
        unionSet.addAll(set2); // Add all elements of set2

        // Compute intersection of two sets
        Set<Integer> intersectionSet = new HashSet<>(set1); // Copy set1 elements
        intersectionSet.retainAll(set2); // Keep only common elements with set2

        // Display the results
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);
    }
}
