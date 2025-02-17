package org.capgemini.annotations.exercise.exercise4;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) {
        try {
            // Get the TaskManager class
            Class<TaskManager> taskManagerClass = TaskManager.class;

            // Get the method which has the annotation
            Method method = taskManagerClass.getMethod("completeTask");

            // Check if the annotation is present
            if (method.isAnnotationPresent(TaskInfo.class)) {
                // Retrieve the annotation
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                // Print annotation details
                System.out.println("Task Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            } else {
                System.out.println("No TaskInfo annotation found.");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
