package org.capgemini.annotations.exercise.exercise5;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Define the @BugReport annotation and make it repeatable
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
public @interface BugReport {
    String description();
}
