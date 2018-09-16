package com.pwq.mavenT;

/**
 * Created by BF100500 on 2017/3/21.
 */
public class WorkRunnable implements Runnable {
    public void run() {
        System.out.println("complete a task");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }
}
