package com.pwq.lockTest;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pwq on 2018/6/15.
 */
public class Test {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();    //注意这个地方
    public static void main(String[] args)  {
        final Test test = new Test();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }

    public void insert(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
}
