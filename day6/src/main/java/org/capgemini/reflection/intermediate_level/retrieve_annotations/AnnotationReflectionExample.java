package org.capgemini.reflection.intermediate_level.retrieve_annotations;

public class AnnotationReflectionExample {
    public static void main(String[] args) throws Exception {
        // Get the class object of Book
        Class<?> bookClass = Book.class;

        // Check if the @Author annotation is present on the class
        if (bookClass.isAnnotationPresent(Author.class)) {
            // Retrieve the @Author annotation
            Author authorAnnotation = bookClass.getAnnotation(Author.class);

            // Display the value of the 'name' element from the annotation
            System.out.println("Author: " + authorAnnotation.name());
        } else {
            System.out.println("No Author annotation present.");
        }
    }
}
