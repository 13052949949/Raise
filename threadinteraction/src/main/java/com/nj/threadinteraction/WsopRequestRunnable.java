package com.nj.threadinteraction;

/**
 * @author：gao
 * @date：2023/2/12
 * @desc：
 **/
public class WsopRequestRunnable implements Runnable {

    int progress;
    String domain;
    WsopRequestCallback callback;

    public WsopRequestRunnable(int progress, String domain, WsopRequestCallback callback) {
        this.progress = progress;
        this.domain = domain;
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (progress < 4){
            callback.onResult(false, new Object());
        }else {
            callback.onResult(true, new Object());
        }

    }
}
