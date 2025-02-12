package org.capgemini.queue_interface.problem_3;

import java.util.*;


//define a patient class
class Patient{
    String name;
    int severity;

    Patient(String name, int severity){
        this.name = name;
        this.severity = severity;
    }
}

//Returns a queue of patients based on severity
public class HospitalTriageSystem {

    //main method
    public static void main(String[] args) {

        //mock test objects list
        List<Patient> list = List.of(new Patient("John", 3),
                new Patient("Alice", 5), new Patient("Bob",2));

        //define the result queue
        PriorityQueue<Patient> queue = orderPatients(list);

        //print the names
        queue.forEach(patient -> System.out.println(patient.name));

    }

    public static PriorityQueue<Patient> orderPatients(List<Patient> list){

        //define a max heap
        PriorityQueue<Patient> patients = new PriorityQueue<>((p1,p2) -> p2.severity - p1.severity);

        //add patients to queue
        list.forEach(patients::add);

        return patients;
    }
}
