package com.example;

import java.lang.reflect.Field;
import java.math.BigInteger;

/**
 * Created by chengjian on 17-11-23.
 */

public class TestInteger {
    private static final int MODE_MASK = 0x3 << 30;

    public static void main(String[] args) {
        int i = 0;
        int m = -2147482193;
        int n = -2147483648;
        int x = 1073742904;
        int y = 1073743369;
        int z = -2147483647;
        String[] aa = new String[1];
        aa[i++] = "ssaf";
        System.out.println("i=" + i + ",aa=" + aa[0]);
        System.out.println(Integer.toHexString(z));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println("MODE_MASK=" + Integer.toBinaryString(MODE_MASK));
        System.out.println(m & n);
        System.out.println("gdgd=" + (x & MODE_MASK));
        System.out.println((3 << 30));
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
            System.out.println(Integer.toHexString(-1));
            System.out.println(33 % 10);
            System.out.println(new BigInteger("11111111111111111111111111011111", 2));
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
