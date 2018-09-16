package com.pwq.DesignPatterns.SimpleFactory.Mediator;



/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:00 2017/11/2
 * @Modified By：
 */
public class test {
    public static void main(String[] args) {
        TestB testB = new TestB();
        TestA testA = new TestA(testB);
        testA.method();
    }
}
