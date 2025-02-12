package org.capgemini.map_interface.problem_1;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    public static Map<String, Integer> countFrequency(String s){


        Map<String, Integer> map = new HashMap<>();

        String[] arr = s.toLowerCase().trim().split("\\s+");


        for (String string : arr){
            String refinedString = refineString(string);

            map.put(refinedString, map.getOrDefault(refinedString,0)+1);
        }
        return map;
    }

    private static String refineString(String s){
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c >= 97 && c<= 122) sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(countFrequency("Hello world, hello Java!"));
    }
}
