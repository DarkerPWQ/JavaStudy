package com.pwq.ThreadPool;

import com.pwq.again.InThread;

/**
 * Created by BF100500 on 2017/3/21.
 */
public class WorkThread extends Thread {
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName());
            System.out.println("aaaa");
//            InThread inThread = new InThread();
//            inThread.start();
//            InThread inThread1 = new InThread();
//            inThread1.start();
//            System.out.println("no");
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
