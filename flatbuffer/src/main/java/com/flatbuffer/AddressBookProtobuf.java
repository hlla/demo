package com.flatbuffer;

import android.os.Environment;

import com.example.tutorial.AddressBookProtos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddressBookProtobuf {

    public static File encodeTest(int count) {
        File dir = Environment.getExternalStorageDirectory();
        File file = new File(dir, "address");
        AddressBookProtos.AddressBook.Builder addressBook = AddressBookProtos.AddressBook
                .newBuilder();

        for (int i = 0; i < count; ++i) {
            addressBook.addPerson(AddressBookProtos.Person.newBuilder().setName("cheetamobile"));
        }
        AddressBookProtos.AddressBook book = addressBook.build();
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            book.writeTo(outputStream);
            outputStream.close();
        } catch (IOException e) {
        }
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        try {
//            book.writeTo(baos);
//        } catch (IOException e) {
//        }

        return file;
    }


//    public static byte[] encodeTest(String[] names, int times) {
//        for (int i = 0; i < times - 1; ++i) {
//            encodeTest(names);
//        }
//        return encodeTest(names);
//    }

    public static AddressBookProtos.AddressBook decodeTest() {
        AddressBookProtos.AddressBook addressBook = null;
        try {
            File dir = Environment.getExternalStorageDirectory();
            File file = new File(dir, "address");
            FileInputStream inputStream = new FileInputStream(file);
            addressBook = AddressBookProtos.AddressBook.parseFrom(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addressBook;
    }

//    public static AddressBookProtos.AddressBook decodeTest(InputStream is, int times) {
//        AddressBookProtos.AddressBook addressBook = null;
//        for (int i = 0; i < times; ++i) {
//            addressBook = decodeTest(is);
//        }
//        return addressBook;
//    }
}
