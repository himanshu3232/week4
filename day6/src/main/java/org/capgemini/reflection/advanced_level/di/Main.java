package org.capgemini.reflection.advanced_level.di;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // Create a DI container
        SimpleDIContainer container = new SimpleDIContainer();

        // Register the Service class instance
        container.register(Service.class, new Service());

        // Resolve the Client class (the container will inject the Service dependency)
        Client client = container.resolve(Client.class);

        // Call the method that depends on Service
        client.doWork();  // Output: Service is working!
    }
}
