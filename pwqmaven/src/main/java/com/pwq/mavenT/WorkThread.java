package com.pwq.mavenT;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by BF100500 on 2017/3/21.
 */
public class WorkThread extends Thread{
    private Runnable target;
    private AtomicInteger counter;

    public WorkThread(Runnable target,AtomicInteger count){
        this.target = target;
        this.counter = count;
    }

    @Override
    public void run() {
        try{
            System.out.println("线程运行开始");
            target.run();
            System.out.println("线程运行结束");
        }finally {
            int c = counter.getAndDecrement();
            System.out.println("terminate no"+ c + "Thread");
        }
    }
}
