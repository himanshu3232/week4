package org.capgemini.set_interface.problem_5;

import java.util.Set;

public class CheckSubset {

    public static <E> boolean checkSubset(Set<E> set1, Set<E> set2){
        //find the subset
        if(set1.size() > set2.size()) return helper(set1,set2);
        return helper(set2,set1);
    }

    private static <E> boolean helper(Set<E> set, Set<E> subset){

        //check if all elements are present in the set from the subset
        for(E element : subset){
            if(!set.contains(element)) return false;
        }

        return true;
    }

    //main method
    public static void main(String[] args) {
        if(checkSubset(Set.of(1,2,3,4,5),Set.of(3,1,2)))
            System.out.println("Set is a subset");
        else
            System.out.println("Set is not a subset");
    }
}
