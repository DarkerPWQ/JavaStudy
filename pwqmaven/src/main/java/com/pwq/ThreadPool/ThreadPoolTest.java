package com.pwq.ThreadPool;

import com.pwq.mavenT.TryTest;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 18:49 2017/8/1
 * @Modified By：
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(Thread.activeCount());
        System.out.println("-------");
        WorkThread workThread = new WorkThread();
        WorkThread workThread1 = new WorkThread();
        for (int i = 0; i < 10; i++) {

            executorService.execute(new ThreadPool());
            System.out.println("************* a" + i + " *************");
        }
        executorService.shutdown();
//        executorService.execute(new TestRunnable());
//        executorService.execute(new TestRunnable());
        System.out.println("我他妈已经结束了，你们2个干嘛");
        //    executorService.shutdown();
        System.out.println(Thread.activeCount());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.activeCount());
        executorService.shutdown();
    }

}
