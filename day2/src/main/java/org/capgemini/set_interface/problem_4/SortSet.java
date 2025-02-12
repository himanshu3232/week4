package org.capgemini.set_interface.problem_4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortSet {
    public static void main(String[] args) {

        //define a hashSet
        Set<Integer> set = new HashSet<>(Set.of(3,4,1,2,5,6,8,7));

        //sort the set
        Set<Integer> sortedList = new TreeSet<>(set);

        //convert set to list
        List<Integer> list = sortedList.stream().toList();

        //print sorted list
        System.out.println(list);
    }
}
