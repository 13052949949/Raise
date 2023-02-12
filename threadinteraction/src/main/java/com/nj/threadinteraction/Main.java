package com.nj.threadinteraction;

public class Main {

    public static void main(String[] args) {
//        runThreadInteractionDemo();
//        runWaitDemo();
        runNetworkTestDemo();
    }

    static void runThreadInteractionDemo() {
        new ThreadInteractionDemo().runTest();
    }

    static void runWaitDemo(){
        new WaitDemo().runTest();
    }

    static void runNetworkTestDemo(){
        new WsopRequestDemo().runTest();
    }

}