package org.capgemini.queue_interface.problem_5;

import java.util.Arrays;

public class CircularBuffer {
    private int[] buffer;
    private int size, front, rear, count;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Insert element (overwrite oldest if full)
    public void insert(int value) {
        rear = (rear + 1) % size; // Move rear circularly
        buffer[rear] = value;

        if (count < size) {
            count++; // Increase count if not full
        } else {
            front = (front + 1) % size; // Move front to overwrite oldest
        }
    }

    // Get buffer contents
    public int[] getBuffer() {
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = buffer[(front + i) % size];
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer())); // [1, 2, 3]

        cb.insert(4); // Overwrites 1
        System.out.println("Buffer: " + Arrays.toString(cb.getBuffer())); // [2, 3, 4]
    }
}
