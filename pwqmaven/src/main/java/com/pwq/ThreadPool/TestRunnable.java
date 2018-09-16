package com.pwq.ThreadPool;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:34 2017/8/1
 * @Modified By：
 */
public class TestRunnable implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
        while (true) {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
