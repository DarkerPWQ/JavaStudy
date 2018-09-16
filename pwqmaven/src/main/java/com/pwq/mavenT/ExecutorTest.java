package com.pwq.mavenT;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.Executor;

/**
 * Created by BF100500 on 2017/3/17.
 */
class MyRunnable implements Runnable{
    public void run() {
        for(int i= 0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
public class ExecutorTest {
    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.shutdown();
    }
}
