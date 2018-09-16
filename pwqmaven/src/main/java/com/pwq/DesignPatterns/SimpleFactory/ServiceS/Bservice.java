package com.pwq.DesignPatterns.SimpleFactory.ServiceS;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:49 2017/11/3
 * @Modified By：
 */
public class Bservice implements Service {
    @Override
    public void service() {
        System.out.println("提供B服务");
    }
}
