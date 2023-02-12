package com.nj.threadsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author：gao
 * @date：2023/2/11
 * @desc：
 **/
public class ThreadManager {

    private static volatile ExecutorService mInstance;

    public static ExecutorService get() {
        if (mInstance == null) {
            synchronized (ThreadManager.class){
                if (mInstance == null){
                    mInstance = new ThreadPoolExecutor(5, 100, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
                }
            }
        }
        return mInstance;
    }

}
