package com.pwq.mavenT;

/**
 * Created by BF100500 on 2017/4/5.
 */
public class IntTest {
    private static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        final Object object = new Object();

        Thread thread = new Thread(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                while(!stop){
                    i++;
                    synchronized (object){
                        System.out.println("t 线程进去");
                            stop = true;
                        //堵住
                        System.out.println("已经修改了，看看是不是对外界里面可见？");
                        System.out.println("t线程出来");
                        System.out.println(stop);
                    }
                }
            }
        });
        thread.start();

        while (true){
            if(stop){
                System.out.println("更新了");
            }
        }

    }

}
