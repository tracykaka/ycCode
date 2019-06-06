package com.yingchong.service.data_service.service.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CompareThread {

    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(10, 20,
                120L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
    }

    /*public static void main(String[] args) {
        ExecutorService pool = newCachedThreadPool();
        pool.execute();
    }*/

}
