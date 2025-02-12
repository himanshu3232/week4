package org.capgemini.list_interface.problem_3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7));
        System.out.println(list);
        RotateList.rotateBy(list, 1);
        System.out.println(list);
        RotateList.rotateBy(list, 2);
        System.out.println(list);
    }
}
