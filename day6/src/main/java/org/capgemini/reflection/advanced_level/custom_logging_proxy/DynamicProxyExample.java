package org.capgemini.reflection.advanced_level.custom_logging_proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyExample {
    public static void main(String[] args) {
        // Create an instance of the original object
        Greeting greeting = new GreetingImpl();

        // Create a proxy instance of Greeting
        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class<?>[] { Greeting.class },
                new LoggingInvocationHandler(greeting)  // Provide the InvocationHandler
        );

        // Call the method on the proxy
        proxyGreeting.sayHello();
    }
}
