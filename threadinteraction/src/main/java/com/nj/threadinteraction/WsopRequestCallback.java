package com.nj.threadinteraction;

/**
 * @author：gao
 * @date：2023/2/12
 * @desc：
 **/
public interface WsopRequestCallback {
    void onResult(boolean success, Object result);

    void onError();
}
