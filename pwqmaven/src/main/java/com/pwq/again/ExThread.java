package com.pwq.again;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by BF100500 on 2017/3/21.
 */
public class ExThread extends Thread{
    private  Runnable target;
    private AtomicInteger count;


    ExThread(Runnable target,AtomicInteger count){
        this.target = target;
        this.count = count;
    }
    @Override
    public void run() {
        target.run();
    }
}
