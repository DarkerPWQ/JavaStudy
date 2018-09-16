package com.pwq.DesignPatterns.SimpleFactory;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:54 2017/9/19
 * @Modified By：
 */
public class Test {
    public static void main(String[] args) {
        TV tv = SimpleFactory.getInstance("hx");
        tv.TvName();
        String bill = "2017-05";
        System.out.println(bill.substring(0,4));

    }
}
