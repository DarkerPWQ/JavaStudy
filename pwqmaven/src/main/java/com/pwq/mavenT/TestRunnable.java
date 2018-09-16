package com.pwq.mavenT;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:32 2017/7/31
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
