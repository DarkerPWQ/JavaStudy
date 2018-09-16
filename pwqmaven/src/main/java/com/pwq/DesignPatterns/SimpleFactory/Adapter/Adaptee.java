package com.pwq.DesignPatterns.SimpleFactory.Adapter;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 11:25 2017/9/29
 * @Modified By：
 */
public class Adaptee {
    public String api(String s){
        return "我正在对"+s+"进行分装";
    }
}
