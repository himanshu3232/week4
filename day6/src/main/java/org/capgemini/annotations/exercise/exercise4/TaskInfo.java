package org.capgemini.annotations.exercise.exercise4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Annotation is available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
public @interface TaskInfo {
    int priority();
    String assignedTo();
}

