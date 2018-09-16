package com.pwq.mavenT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by BF100500 on 2017/3/21.
 */
public class TestThreadFactory {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
        ExecutorService es = Executors.newCachedThreadPool(new WorkThreadFactory());
        es.execute(new WorkRunnable());
        es.execute(new WorkRunnable());
        es.execute(new WorkRunnable());
        es.execute(new WorkRunnable());
        es.execute(new WorkRunnable());
        es.shutdown();
        try{
            es.awaitTermination(2*60, TimeUnit.SECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
