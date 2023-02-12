package com.nj.threadsync;

/**
 * @author：gao
 * @date：2023/2/11
 * @desc：
 **/
public class Synchronized1Demo implements TestDemo{

    volatile boolean running = true;

    private void stop(){
        running = false;
    }

    @Override
    public void runTest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running){

                }
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop();
    }
}
