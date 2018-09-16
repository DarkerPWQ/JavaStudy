package com.pwq.DesignPatterns.SimpleFactory.Mediator;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:20 2017/11/2
 * @Modified By：
 */
public class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void method1() {

    }

    @Override
    public void method2() {
        System.out.println("我是那个时候的B");

    }
}
