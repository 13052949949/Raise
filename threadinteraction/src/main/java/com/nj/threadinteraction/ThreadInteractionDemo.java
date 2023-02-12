package com.nj.threadinteraction;

import static java.lang.Thread.interrupted;

/**
 * @author：gao
 * @date：2023/2/11
 * @desc：
 **/
public class ThreadInteractionDemo implements TestDemo {
    @Override
    public void runTest() {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    if (Thread.interrupted()){
                        return;
                    }
                    System.out.println("number:" + i);
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
