package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserialTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = null;
        ArrayList<Person> persons = null;
        FileInputStream fis = new FileInputStream("Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
//        persons = (ArrayList<Person>) ois.readObject();
        person = (Person) ois.readObject();
        ois.close();
        System.out.println("Person Deserial=" + person);
//        System.out.println("Person persons=" + persons);
    }

}
