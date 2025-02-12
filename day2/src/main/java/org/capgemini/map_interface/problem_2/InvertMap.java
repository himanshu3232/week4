package org.capgemini.map_interface.problem_2;

import java.util.*;

public class InvertMap {

    public static <K,V> Map<V, List<K>> listOfDuplicates(Map<K,V> map){
        Map<V, List<K>> result = new HashMap<>();

        for(Map.Entry<K,V> element : map.entrySet()){
            V value = element.getValue();
            if(result.containsKey(value)){
                List<K> list = result.get(value);
                list.add(element.getKey());
                result.put(value, list);
            }
            else result.put(value, new ArrayList<>(List.of(element.getKey())));
        }

        return result;
    }
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(Map.of("A", 1, "B", 2, "C", 1));

        System.out.println(listOfDuplicates(map));
    }
}
