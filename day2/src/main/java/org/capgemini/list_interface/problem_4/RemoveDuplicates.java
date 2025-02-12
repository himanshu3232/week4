package org.capgemini.list_interface.problem_4;

import java.util.*;

public class RemoveDuplicates {

    private static <E> void removeDuplicates(List<E> list){
        Set<E> set = new HashSet<>();
        for(E element : list) set.add(element);

        list.clear();
        for(E element : set) list.add(element);
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,3,3,3,1,1,1,2));
        System.out.println(list);
        removeDuplicates(list);
        System.out.println(list);
    }
}
