package com.example;

/**
 * Created by chengjian on 17-10-12.
 */

public class TestTimer {
    public TestTimer() {
        aa = 3;
        System.out.println("TestTimer aa=" + aa);
    }

    public int aa;

    class MyTest extends TestTimer {
        public int aa = 2;

        public MyTest() {
            System.out.println("MyTest aa=" + aa);
        }

    }

    static int i = 0;

    static int add(int a, int b) {
        int sum = a;

	/*直到进位的结果为0*/
        while (b != 0) {
            sum = a ^ b; /*不考虑进位的和*/
            b = (a & b) << 1; /*只考虑进位的产生值*/
            a = sum;
        }//while
        return sum;
    }

    public static void main(String[] args) {
        int[][] sss=new int[3][4];
        System.out.println("MyTest sss.length=" + sss.length+"  lengtg11="+sss[0].length);
        TestTimer aa =new TestTimer().new MyTest();
        System.out.println("MyTest 111 aa=" + aa.aa);
        int totalRed = 0;
        int totalRed1 = 0;
        int totalRed2 = 0;
        int total = 2 << Integer.SIZE - 1;
        System.out.println("start time=" + System.currentTimeMillis());
        new Thread() {
            @Override
            public void run() {
                super.run();
                TestVolatile.isTestAA();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                super.run();
                TestVolatile.isTestAA();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                super.run();
                TestVolatile.isTestAA();
            }
        }.start();
        for (int i = 0; i <= 8000; i++) {
            for (int j = 0; j <= 8000; j++) {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        boolean ss = TestVolatile.stop;
                    }
                };
//                Random random = new Random();
//                totalRed += random.nextInt(255);
//                totalRed1 += random.nextInt(255);
//                totalRed2 += random.nextInt(255);
                totalRed += 99;
                totalRed1 += 88;
                totalRed2 += 76;
//                totalRed += add(totalRed, 199);
////                total = totalRed;
//                totalRed1 += add(totalRed, 236);
//                totalRed2 += add(totalRed, 187);
            }
        }
        System.out.println("end11 time=" + System.currentTimeMillis());
        System.out.println("totalRed=" + totalRed + " totalRed1=" + totalRed1 + " totalRed2=" +
                totalRed2);
//        final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date startDate = new Date();
//        try {
//            startDate = dateFormatter.parse("2010/11/28 01:06:00");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(" time=" + dateFormatter.format(new Date()));
//
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                i++;
//                System.out.println(" time=" + dateFormatter.format(new Date()) + " tid=" +
//                        Thread.currentThread().getId());
//                try {
////                    if (i == 4) {
////                        Thread.sleep(5000);
////                    } else {
//                    Thread.sleep(1000);
////                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, 0, 2000);
    }
}
