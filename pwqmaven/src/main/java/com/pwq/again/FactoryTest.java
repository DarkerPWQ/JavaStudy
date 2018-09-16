package com.pwq.again;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by BF100500 on 2017/3/21.
 */
public class FactoryTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool(new MyThreadFactory());
        es.execute(new WorkThread());

        es.execute(new WorkThread());
        es.execute(new WorkThread());
        es.execute(new WorkThread());
        es.shutdown();



    }
}
