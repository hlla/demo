package com.example.testclient1;
import com.example.testclient1.School;
  interface testcopyone {
    void performAction(out School sc);
    School getAdId();
    void testCall(in List<School> ssss);
    List<School> test();
    void testout(inout School sc);
    School[]  testArray(in School sc);
    }