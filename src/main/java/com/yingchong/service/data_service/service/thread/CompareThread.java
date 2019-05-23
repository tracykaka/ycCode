package com.yingchong.service.data_service.service.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompareThread {

    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(10, 10000,
                120L, TimeUnit.SECONDS,
                new SynchronousQueue<>());
    }

    /*public static void main(String[] args) {
        ExecutorService pool = newCachedThreadPool();
        pool.execute();
    }*/

}
