package com.pwq.ThreadTest;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by pwq on 2018/4/6.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Executor executor = new ThreadPoolExecutor(5,15,20, TimeUnit.MINUTES,new LinkedBlockingDeque<Runnable>());
        for(int i=0;i<1500;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("wanbi");
    }
}
