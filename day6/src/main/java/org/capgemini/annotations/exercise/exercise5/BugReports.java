package org.capgemini.annotations.exercise.exercise5;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Container annotation to hold multiple @BugReport annotations
@Retention(RetentionPolicy.RUNTIME)
public @interface BugReports {
    BugReport[] value();
}


