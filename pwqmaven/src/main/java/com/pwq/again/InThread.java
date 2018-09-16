package com.pwq.again;

import com.pwq.utils.StaticTest;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 18:38 2017/8/1
 * @Modified By：
 */
public class InThread extends Thread{
    private String name;

    public InThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        super.run();
        System.out.println(name);
        StaticTest.count();
    }
}
