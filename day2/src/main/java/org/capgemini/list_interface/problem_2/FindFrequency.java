package org.capgemini.list_interface.problem_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequency {
    public static <E> Map<E, Integer> findFrequency(List<E> list){
        Map<E, Integer> map = new HashMap<>();
        for(E e : list) map.put(e, map.getOrDefault(e, 0)+1);

        return map;
    }
}
