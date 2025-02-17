package org.capgemini.reflection.intermediate_level.retrieve_annotations;

// Apply the @Author annotation to a class
@Author(name = "Author Name")
public class Book {
    public void displayInfo() {
        System.out.println("This is a Book class.");
    }
}