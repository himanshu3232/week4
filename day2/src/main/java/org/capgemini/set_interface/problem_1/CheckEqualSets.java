package org.capgemini.set_interface.problem_1;

import java.util.Set;

//Compares two sets and determines if they contain the same elements, regardless of order.
public class CheckEqualSets {
    public static <T> boolean checkEqualSets(Set<T> set1, Set<T> set2){

        //compare set1 with set2
        for(T element : set1){
            if(!set2.contains(element)) return false;
        }

        //compare set2 with set1
        for(T element : set2){
            if(!set1.contains(element)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //mock objects
        Set<String> set1 = Set.of("abc", "pqr", "ele", "ok");
        Set<String> set2 = Set.of("ele", "ok", "abc", "pqr");

        if(checkEqualSets(set1, set2)) System.out.println("Sets are equal");
        else System.out.println("Sets are not equal");
    }
}
