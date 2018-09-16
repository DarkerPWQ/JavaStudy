package com.pwq.ThreadPool;

import com.pwq.again.InThread;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:57 2017/12/12
 * @Modified By：
 */
public class StaticTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println("aaaa");
        InThread inThread = new InThread("pwq");
        inThread.start();
        InThread inThread1 = new InThread("gwt");
        inThread1.start();
        System.out.println("no");
    }
}
