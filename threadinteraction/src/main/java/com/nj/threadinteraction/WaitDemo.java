package com.nj.threadinteraction;

/**
 * @author：gao
 * @date：2023/2/11
 * @desc：
 **/
public class WaitDemo implements TestDemo {

    String name;

     synchronized void initName(){
        name = "renwuxian";
        notifyAll();
    }

     synchronized void printName(){
        if (name == null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("name:" + name);
    }

    @Override
    public void runTest() {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                initName();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                try {
//                    thread1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                printName();
            }
        });
        thread2.start();

//        try {
//            thread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("last line!");
    }
}
