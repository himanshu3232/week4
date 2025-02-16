package org.example.junit.basic;

public class TaskUtils {
    // Simulates a long-running task
    public static String longRunningTask() {
        try {
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}