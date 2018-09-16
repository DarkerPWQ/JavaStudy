package com.pwq.DesignPatterns.SimpleFactory.Mediator;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:08 2017/11/2
 * @Modified By：
 */
public class ConcreteMediator extends Mediator{
    @Override
    public void operation() {
        colleagues.get(0).method2();
        colleagues.get(1).method2();

    }
}
