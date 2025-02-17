package org.capgemini.annotations.exercise.exercise4;

public class TaskManager {

    // Applying the custom annotation to a method
    @TaskInfo(priority = 1, assignedTo = "John Doe")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}
