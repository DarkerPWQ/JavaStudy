package com.pwq.Callable;

import java.util.concurrent.Callable;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:41 2017/8/4
 * @Modified By：
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("call()方法被调用"+Thread.currentThread().getName());
        for(int i=99999;i>0;i--);
        return "call()被自动调用，任务结果为:"+id+"  "+Thread.currentThread().getName();

    }
}
