package com.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by chengjian on 16/9/27.
 */

public class SerialTest {

    public static void main(String[] args) throws IOException {
        String aa = null;
        Person person = new Person(1234, "wang");
        System.out.println("Person Serial" + person);
        FileOutputStream fos = new FileOutputStream("Person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        ArrayList<Person> persons = new ArrayList<Person>();
//        persons.add(person);
        oos.writeObject(person);
        oos.flush();
        oos.close();
        Person person1 = null;
//        Person ss = (Person) person1;
//        System.out.println(ss);
        try {
            person1 = (Person) person.clone();
            person1.address.country = "english";
            person1.addressArrayList.add(person1.new Address("Italy", "ROMA"));
            person1.hashMap.put("AAAA", "BBBB");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Person clone" + person);
        System.out.println("Person1 clone" + person1);
        person.address.country = "ccccccc";
        person.addressArrayList.add(person1.new Address("AAAAA", "BBB"));
        System.out.println("Person111 clone" + person1);
    }
}
