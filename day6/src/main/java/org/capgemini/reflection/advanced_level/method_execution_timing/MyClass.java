package org.capgemini.reflection.advanced_level.method_execution_timing;

public class MyClass {
    public void methodOne() throws InterruptedException {
        // Simulating some work
        Thread.sleep(500);
        System.out.println("Method One Executed");
    }

    public void methodTwo() throws InterruptedException {
        // Simulating some work
        Thread.sleep(300);
        System.out.println("Method Two Executed");
    }
}
