package com.pwq.mavenT;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by BF100500 on 2017/3/21.
 */
public class WorkThreadFactory implements ThreadFactory {
    private AtomicInteger atomicInteger =  new AtomicInteger(0);
    public void printString(){
        System.out.println("here");
    }

    public Thread newThread(Runnable r) {
        int c = atomicInteger.incrementAndGet();
        System.out.println("create no" + c +"thread");
        printString();
        return new WorkThread(r,atomicInteger);
    }
}
