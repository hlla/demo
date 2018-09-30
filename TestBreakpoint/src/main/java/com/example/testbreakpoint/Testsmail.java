package com.example.testbreakpoint;

import android.util.Log;

/**
 * Created by chengjian on 18-8-23.
 */

public class Testsmail {
    private int test(int a) {
        int aa[] = {10, 2, 3};
        int bb = aa.length;
        if (bb > 0) {
            Log.d("gfdg", "sdsaff: ");
        }
        boolean isOne = testone(2);
        int b = a * 2;
        if (isOne) {
            for (int i = 0; i < 4; i++) {
                if (i == 3) {
                    break;
                }
            }
            a = 1;
            Log.d("gfdg", "test: ");
            if (b == 2) {
                Log.d("gfdg", "abc: ");
                b = 10;
                return b;
            } else {
                b = 10;
            }
        } else {
            a = 2;
        }
        return a * b;
    }

    private boolean testone(int i) {
        if (i == 2) {
            return true;
        } else {
            return false;
        }
    }
}
