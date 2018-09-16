package com.pwq.Callable;

import org.apache.ibatis.executor.Executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:45 2017/8/4
 * @Modified By：
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList();
        //创建10个任务
        for(int i=0;i<10;i++){
            Future<String> future = executorService.submit(new TaskWithResult(i));
            resultList.add(future);
        }
        for(int i=0;i<10;i++){
            Future<String> future = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "无形之刃最为致命"+Thread.currentThread().getName();
                }
            });
            resultList.add(future);
        }
        for(Future<String> fs:resultList){
            try{
                System.out.println(fs.get());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //启动一次顺序关闭，执行以前提交的任务，但是不接受新的任务了
                executorService.shutdown();
            }
        }

    }
}
