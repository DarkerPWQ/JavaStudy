package com.pwq.DesignPatterns.SimpleFactory.Component;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:48 2017/10/12
 * @Modified By：
 */
public abstract class Component {//抽象类实现
    public abstract void add(Component component);//增加
    public abstract void remove(Component component);//删除
    public abstract Component get(int i);//查询
    public abstract void operation();//操作
}
