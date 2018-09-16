package com.pwq.again;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by BF100500 on 2017/3/21.
 */
public class MyThreadFactory implements ThreadFactory{
    private AtomicInteger count = new AtomicInteger(0);
    public Thread newThread(Runnable r) {
        System.out.println("工厂创建中");
        return new ExThread(r,count);
    }
}
