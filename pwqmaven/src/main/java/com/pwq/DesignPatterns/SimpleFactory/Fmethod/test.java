package com.pwq.DesignPatterns.SimpleFactory.Fmethod;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 11:39 2017/9/19
 * @Modified By：
 */
public class test {
    public static void main(String[] args) {
        IFactory factory = new HxFactory();
        TV tv = factory.getInstance();
        tv.TvName();
    }
}
