package com.nj.threadsync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author：gao
 * @date：2023/2/11
 * @desc：
 **/
public class Synchronized2Demo implements TestDemo {

    int x ;

     synchronized void count() {
         x++;
    }

    @Override
    public void runTest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    count();
                }
                System.out.println("final x from Thread1 : " + x);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    count();
                }
                System.out.println("final x from Thread2 : " + x);
            }
        }).start();
    }
}
