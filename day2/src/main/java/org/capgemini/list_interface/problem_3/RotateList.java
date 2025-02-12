package org.capgemini.list_interface.problem_3;

import java.util.List;

public class RotateList {
    public static <E> void rotateBy(List<E> list, int n){
        reverse(list, 0, list.size()-1);
        reverse(list, 0, n-1);
        reverse(list, n, list.size()-1);
    }

    private static <E> void reverse(List<E> list, int s, int e){
        if(s>=e) return;

        E temp = list.get(s);
        list.set(s,list.get(e));
        list.set(e,temp);

        reverse(list, s+1, e-1);
    }
}
