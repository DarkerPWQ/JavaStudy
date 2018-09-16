package com.pwq.staticT;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 15:55 2018/1/3
 * @Modified By：
 */
public class StaticSub {
    public static int a = 3;
    static {
        System.out.println("在主加载的过程中，会不会跟着解析阶段把我加载？？？");
    }
}
