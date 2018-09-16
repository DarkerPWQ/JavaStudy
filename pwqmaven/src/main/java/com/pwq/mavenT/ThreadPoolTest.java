package com.pwq.mavenT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:31 2017/7/31
 * @Modified By：
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//                ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
//         ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            executorService.execute(new TestRunnable());
            System.out.println("************* a" + i + " *************");
        }
        executorService.shutdown();
        System.out.println("关闭了？？");
    }
}
