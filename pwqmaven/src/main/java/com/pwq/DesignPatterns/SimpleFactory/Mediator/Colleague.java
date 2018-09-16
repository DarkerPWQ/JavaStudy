package com.pwq.DesignPatterns.SimpleFactory.Mediator;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:09 2017/11/2
 * @Modified By：
 */
public abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator){
        this.mediator=mediator;
    }
    public abstract void method1();
    public abstract void method2();
}
