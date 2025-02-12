package org.capgemini.set_interface.problem_3;

import java.util.*;

public class SetUnionIntersection {
    public static void main(String[] args) {
        // Define two sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Compute union of two sets
        Set<Integer> unionSet = computeUnion(set1, set2);

        // Compute intersection of two sets
        Set<Integer> intersectionSet = computeIntersection(set1, set2);

        // Compute symmetric difference of two sets
        Set<Integer> symmetricDifferenceSet = computeSymmetricDifference(set1, set2);

        // Display the results
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Union: " + unionSet);
        System.out.println("Intersection: " + intersectionSet);
        System.out.println("Symmetric Difference: " + symmetricDifferenceSet);
    }

    // Function to compute union of two sets
    private static Set<Integer> computeUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    // Function to compute intersection of two sets
    private static Set<Integer> computeIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    // Function to compute symmetric difference of two sets
    private static Set<Integer> computeSymmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        result.removeAll(intersection);
        return result;
    }
}
