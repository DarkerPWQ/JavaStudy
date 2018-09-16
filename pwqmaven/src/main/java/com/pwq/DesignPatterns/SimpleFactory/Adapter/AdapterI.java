package com.pwq.DesignPatterns.SimpleFactory.Adapter;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 11:04 2017/9/29
 * @Modified By：
 */
public class AdapterI implements Adapter {
    private Adaptee adaptee;
    @Override
    public String request(String s) {
        return adaptee.api(s);
    }
}
