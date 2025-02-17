package org.capgemini.reflection.basic_level.get_class_info;

public class Example {
    private final String field1;
    private final int field2;

    public Example(String field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    private void method(){
        System.out.println("In method");
    }
}
