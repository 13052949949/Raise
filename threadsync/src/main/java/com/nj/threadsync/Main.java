package com.nj.threadsync;


//什么是进程？
//什么是线程？
//进程和线程的区别？
//线程之间可以共享资源，而进程之间不能共享。什么是共享资源？
//什么是CPU线程？
//什么是操作系统线程？
//为什么UI线程一直在死循环却不会卡住界面？

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

//        thread();
//        runnable();
//        threadFactory();
//        executor();
//        callable();
//        runSynchronized1Demo();
        runSynchronized2Demo();
    }


    /**
     * 使用Thread类来定义工作
     */
    static void thread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread started!");
            }
        });
        thread.start();
    }

    /**
     * 使用Runnable类来定义工作
     */
    static void runnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with runnable started!");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    static void threadFactory() {
        ThreadFactory factory = new ThreadFactory() {
            AtomicInteger count = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "Thread-" + count.incrementAndGet());
            }
        };
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " started!");
            }
        };
        Thread thread = factory.newThread(runnable);
        thread.start();
    }

    static void executor() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with runnable started!");
            }
        };
//         ExecutorService executorService = new ThreadPoolExecutor(5, 100, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//        Executor executor = Executors.newCachedThreadPool();
//         Executors.newSingleThreadExecutor();
//         Executors.newFixedThreadPool(10);
        ThreadManager.get().execute(runnable);
    }

    static void callable() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Done!";
            }
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(callable);
        try {
            String result = future.get();
            System.out.println("result" + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static void runSynchronized1Demo() {
        new Synchronized1Demo().runTest();
    }

    static void runSynchronized2Demo(){
        new Synchronized2Demo().runTest();
    }

}