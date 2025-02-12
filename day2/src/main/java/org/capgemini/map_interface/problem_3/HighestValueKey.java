package org.capgemini.map_interface.problem_3;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HighestValueKey {

    public static <K> K highestKey(Map<K,Integer> map){
        //assume a min value
        int max = Integer.MIN_VALUE;

        //declare and initialize result
        K result = null;

        //iterate through the map to find the max value and update result
        for(Map.Entry<K,Integer> element : map.entrySet()){
            if(element.getValue() > max){
                max = element.getValue();
                result = element.getKey();
            }
        }

        return result;
    }
    public static void main(String[] args) {
        //example map of elements
        Map<String, Integer> map = new HashMap<>(Map.of("A",10,"B",20,"C",15));

        //call method and display result
        System.out.println(highestKey(map));
    }
}
