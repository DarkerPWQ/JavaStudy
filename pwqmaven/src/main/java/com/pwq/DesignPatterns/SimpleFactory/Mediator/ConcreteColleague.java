package com.pwq.DesignPatterns.SimpleFactory.Mediator;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:11 2017/11/2
 * @Modified By：
 */
public class ConcreteColleague extends Colleague {

    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void method1() {
        mediator.register(this);
        mediator.operation();
    }

    @Override
    public void method2() {
        System.out.println("我是那个时候的A");
    }
}
