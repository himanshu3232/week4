package org.capgemini.annotations.intermediate_level.log_method_execution_time;

// Sample class demonstrating the annotation
public class TaskProcessor {
    @LogExecutionTime
    public void processTask() {
        try {
            Thread.sleep(500); // Simulating a task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void quickTask() {
        try {
            Thread.sleep(200); // Simulating a quicker task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}