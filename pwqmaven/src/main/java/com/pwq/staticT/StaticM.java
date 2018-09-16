package com.pwq.staticT;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 15:55 2018/1/3
 * @Modified By：
 */
public class StaticM extends StaticF{
    private static StaticSub staticSub;
    static {
        System.out.println("我是主类，我加载的时候我的属性该咋办？");
        System.out.println(StaticSub.a);


    }
}
