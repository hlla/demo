package com.example;

import java.lang.reflect.Field;

/**
 * Created by chengjian on 17-11-23.
 */

public class TestInteger {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        swap(a, b);
        System.out.println("a=" + a + " b=" + b);
        Integer c = 1;
        Integer d = 2;
        System.out.println("c=" + c + " d=" + d);
    }

    private static void swap(Integer num1, Integer num2) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int temp1 = num1.intValue();
            int temp2 = num2.intValue();
            field.set(num1, temp2);
//            field.set(num2, temp1);
            field.set(num2, new Integer(temp1));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
