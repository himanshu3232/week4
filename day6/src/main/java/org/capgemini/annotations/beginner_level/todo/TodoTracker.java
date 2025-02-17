package org.capgemini.annotations.beginner_level.todo;

import java.lang.reflect.Method;

// Reflection utility to retrieve and print @Todo annotations
public class TodoTracker {
    public static void main(String[] args) {
        Class<Project> obj = Project.class;
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("-----------------------------");
            }
        }
    }
}
