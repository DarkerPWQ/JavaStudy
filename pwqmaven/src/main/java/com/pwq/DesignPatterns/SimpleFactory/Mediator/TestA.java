package com.pwq.DesignPatterns.SimpleFactory.Mediator;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 18:59 2017/11/2
 * @Modified By：
 */
public class TestA {
    private TestB testB;
    public TestA(TestB testB){
        this.testB = testB;
    }
    public void method(){
        System.out.println("这是我自己的输出我是A");
        this.testB.method();
    }
}
