package com.pwq.mavenT;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by BF100500 on 2017/3/21.
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);

        int i1 = ai.get();
        System.out.println(i1);
        int i2 = ai.getAndSet(5);
        System.out.println(i2);
        System.out.println(ai.get());
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.getAndDecrement());
        System.out.println(ai.getAndAdd(10));
        System.out.println(ai.get());
    }

}
