package org.example.junit.basic;

import java.util.List;

// ListManager.java
public class ListManager {
    // Adds an element to the list
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // Removes an element from the list if it exists
    public static void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    // Returns the size of the list
    public static int getSize(List<Integer> list) {
        return list.size();
    }
}