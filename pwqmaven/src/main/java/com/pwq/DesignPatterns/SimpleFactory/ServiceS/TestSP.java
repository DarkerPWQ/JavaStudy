package com.pwq.DesignPatterns.SimpleFactory.ServiceS;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:27 2017/11/3
 * @Modified By：
 */
public class TestSP {
    public static void main(String[] args) throws Exception {
        Class.forName("com.pwq.DesignPatterns.SimpleFactory.ServiceS.Services");
        Service service;
        System.out.println("是否加载了");
        service = Services.getService("A");
        service.service();
        service = Services.getService("B");
        service.service();
        service = Services.getService("C");
        service.service();



    }
}
