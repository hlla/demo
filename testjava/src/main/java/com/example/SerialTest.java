package com.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by chengjian on 16/9/27.
 */

public class SerialTest {

    public static void main(String[] args) throws IOException {
        int aa[] = {10, 8, 23, 9, 67, 1, 12, 4, 7, 2};
//        int aa[] = {11, 8};
        int length = aa.length;
        int temp = 0;
//        for (int i = 0; i < length; i++) {
//            for (int m = 0; m < length - i - 1; m++) {
//                if (aa[m] > aa[m + 1]) {
//                    temp = aa[m];
//                    aa[m] = aa[m + 1];
//                    aa[m + 1] = temp;
//                }
//            }
//        }
        for (int i = 1; i < length; i++) {
            int p = i - 1;
//            int c = i;
            while (p >= 0 && aa[p] > aa[p + 1]) {
//                System.out.println("result ppp=" + p + " aa[p]=" + aa[p] + " aa[p+1]=" + aa[p +
// 1]);
                temp = aa[p];
//                System.out.println("result ppp=" + temp);
                aa[p] = aa[p + 1];
//                System.out.println("result ppp=" + aa[p]);
                aa[p + 1] = temp;
                p--;
//                System.out.println("result ppp=" + p + " aa[p]=" + aa[0] + " aa[p+1]=" + aa[1]);
            }
        }
        for (int a : aa) {
            System.out.println("result a=" + a);
        }
        String aaa = null;
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
