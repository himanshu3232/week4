package org.capgemini.reflection.intermediate_level.retrieve_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the custom annotation @Author
@Retention(RetentionPolicy.RUNTIME) // This ensures the annotation is available at runtime
@Target(ElementType.TYPE) // This specifies the annotation can be applied to a class
public @interface Author {
    String name();
}

