package com.pwq.MDC;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 20:30 2017/9/8
 * @Modified By：
 */

import org.apache.log4j.MDC;

import java.util.Map;

public class ThreadTest extends Thread {
    private int i ;

    private Map<String ,Integer> map;

    public ThreadTest(){
    }

    public ThreadTest(int i){
        this.i = i;
    }

    public void run(){
        System.out.println(++i);
        map.put("username", i);

        for (int j = 0; j < 100; j++) {
            System.out.println("aaa" + i);
            if(j==10){
                try {
                    this.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("run: " + i + "     "  + map.get("username"));
    }

    public static void main(String args[]) throws InterruptedException{
        ThreadTest t1 = new ThreadTest(1);
        t1.start();
        ThreadTest t2 = new ThreadTest(2);
        t2.start();
    }
}