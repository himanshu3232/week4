package org.capgemini.checked_exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//class reads from file and throws exception if file is not found
public class ReadFromFile {
    //main method
    public static void main(String[] args) {
        //try with resources
        try(FileReader fileReader = new FileReader("src/main/resources/data.txt")){
            //reads from file
            while(fileReader.ready()){
                System.out.print((char)fileReader.read());
            }
            System.out.println();
            //throws exception if file is not found
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            //throws other io exceptions
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
