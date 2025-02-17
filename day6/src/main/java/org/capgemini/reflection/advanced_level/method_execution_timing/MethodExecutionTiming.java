package org.capgemini.reflection.advanced_level.method_execution_timing;

import java.lang.reflect.Method;

public class MethodExecutionTiming {

    // Method to measure execution time of any method in the provided object
    public static void measureExecutionTime(Object obj, String methodName, Class<?>[] paramTypes, Object[] args) throws Exception {
        // Get the method from the class
        Method method = obj.getClass().getMethod(methodName, paramTypes);

        // Record the start time
        long startTime = System.currentTimeMillis();

        // Invoke the method dynamically
        method.invoke(obj, args);

        // Record the end time
        long endTime = System.currentTimeMillis();

        // Calculate and display the execution time
        System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) + " milliseconds");
    }

    public static void main(String[] args) {
        try {
            // Create an object of MyClass
            MyClass myClass = new MyClass();

            // Measure the execution time of methodOne
            measureExecutionTime(myClass, "methodOne", new Class<?>[]{}, new Object[]{});

            // Measure the execution time of methodTwo
            measureExecutionTime(myClass, "methodTwo", new Class<?>[]{}, new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
