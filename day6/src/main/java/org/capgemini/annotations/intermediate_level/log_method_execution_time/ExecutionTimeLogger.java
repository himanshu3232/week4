package org.capgemini.annotations.intermediate_level.log_method_execution_time;

import java.lang.reflect.*;


// Utility to measure execution time using reflection
public class ExecutionTimeLogger {
    public static void main(String[] args) throws Exception {
        TaskProcessor processor = new TaskProcessor();
        Method[] methods = TaskProcessor.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(processor);
                long endTime = System.nanoTime();
                System.out.println("Execution Time of " + method.getName() + ": " + (endTime - startTime) / 1_000_000 + " ms");
            }
        }
    }
}
