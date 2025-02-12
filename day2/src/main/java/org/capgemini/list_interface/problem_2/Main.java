package org.capgemini.list_interface.problem_2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("abc", "def", "abc", "pqr", "def", "abc", "pqr");

        System.out.println(FindFrequency.findFrequency(list));
    }
}
