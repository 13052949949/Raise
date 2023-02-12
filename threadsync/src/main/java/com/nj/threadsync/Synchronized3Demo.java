package com.nj.threadsync;

/**
 * @author：gao
 * @date：2023/2/11
 * @desc：
 **/
public class Synchronized3Demo implements TestDemo {

    int x;
    int y;
    String name;
    final Object monitor1 = new Object();
    final Object monitor2 = new Object();

    void count(int value) {
        synchronized (monitor1){
            x = value;
            y = value;
        }
    }

    void minus(int delta) {
        synchronized (monitor1){
            x -= delta;
            y -= delta;
        }
    }

    void setName(String name) {
        synchronized (monitor2){
            this.name = name;
        }
    }

    @Override
    public void runTest() {

    }
}
