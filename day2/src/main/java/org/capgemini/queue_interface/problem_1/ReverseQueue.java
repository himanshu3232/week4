package org.capgemini.queue_interface.problem_1;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static <E> Queue<E> reverseQueue(Queue<E> queue){
        if(queue.isEmpty()) return queue;

        E element = queue.poll();

        reverseQueue(queue);

        queue.add(element);

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        System.out.println(queue);

        System.out.println(reverseQueue(queue));
    }
}
