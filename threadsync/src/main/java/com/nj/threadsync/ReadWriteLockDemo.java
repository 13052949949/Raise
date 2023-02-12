package com.nj.threadsync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author：gao
 * @date：2023/2/11
 * @desc：
 **/
public class ReadWriteLockDemo implements TestDemo{

    int x;
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    void count() {
        writeLock.lock();
        try {
            x++;
        } finally {
            writeLock.unlock();
        }
    }

    void print() {
        readLock.lock();
        try {
            System.out.println("x = " + x);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void runTest() {

    }
}
