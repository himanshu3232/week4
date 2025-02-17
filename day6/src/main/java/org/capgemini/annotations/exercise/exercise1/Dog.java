package org.capgemini.annotations.exercise.exercise1;

// Child class Dog that extends Animal
public class Dog extends Animal {
    // Override the makeSound() method
    @Override
    public void makeSound() {
        System.out.println("The dog barks.");
    }
}
