package com.pwq.utils;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:49 2017/12/12
 * @Modified By：
 */
public class StaticTest {
    public static void count(){
        int i=10;
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"         "+i);
            i++;
        }
    }
}
