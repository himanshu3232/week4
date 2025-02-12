package org.capgemini.queue_interface.problem_2;

import java.util.*;

public class BinaryNumbersQueue {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("1"); // Start with "1"

        for (int i = 0; i < N; i++) {
            String current = queue.poll(); // Get front element
            result.add(current); // Store in result

            // Generate next two binary numbers and add to queue
            queue.offer(current + "0");
            queue.offer(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(generateBinaryNumbers(N));
    }
}
