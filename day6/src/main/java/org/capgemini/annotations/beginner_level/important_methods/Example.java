package org.capgemini.annotations.beginner_level.important_methods;

public class Example {

    @ImportantMethod(priority = Priority.LOW)
    private void method1(){
        System.out.println("Method1");
    }

    @ImportantMethod
    private void method2(){
        System.out.println("Method2");
    }
}
