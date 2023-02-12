package com.nj.threadinteraction;

import java.util.concurrent.Semaphore;

/**
 * @author：gao
 * @date：2023/2/12
 * @desc：
 **/
public class WsopRequestDemo implements TestDemo {

    Semaphore semaphore = new Semaphore(1, true);

    @Override
    public void runTest() {
        for (int i = 0; i < 5; i++) {
            final int progress = i + 1;
            try {
                semaphore.acquire();
                System.out.println("request for " + progress + " times started!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ThreadManager.get().execute(new WsopRequestRunnable(progress, "domain", new WsopRequestCallback() {
                @Override
                public void onResult(boolean success, Object object) {
                    System.out.println("request for" + progress + " times result:" + object + ",timeStamp:" + System.currentTimeMillis());
                    if (success){
                        return;
                    }
                    semaphore.release();
                    System.out.println("request for " + progress + " times finished!");
                }

                @Override
                public void onError() {

                }
            }));
        }
    }
}
