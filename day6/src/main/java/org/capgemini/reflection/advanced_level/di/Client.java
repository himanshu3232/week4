package org.capgemini.reflection.advanced_level.di;

public class Client {
    @Inject
    private Service service;

    public void doWork() {
        service.serve();
    }
}