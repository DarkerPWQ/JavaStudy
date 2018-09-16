package com.pwq.DesignPatterns.SimpleFactory.Adapter;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 11:01 2017/9/29
 * @Modified By：
 */
public class Client {
    private Adapter adapter;
    public String request(String s){
        return adapter.request(s);
    }
}
