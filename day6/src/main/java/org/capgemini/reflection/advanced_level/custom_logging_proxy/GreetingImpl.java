package org.capgemini.reflection.advanced_level.custom_logging_proxy;

public class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}
