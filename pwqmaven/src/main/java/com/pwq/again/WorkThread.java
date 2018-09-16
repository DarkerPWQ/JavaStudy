package com.pwq.again;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BF100500 on 2017/3/21.
 */
public class WorkThread implements Runnable {
    public void run() {

        System.out.println(Thread.currentThread().getName());
        InThread inThread = new InThread("pwq");
        inThread.start();

    }
}
