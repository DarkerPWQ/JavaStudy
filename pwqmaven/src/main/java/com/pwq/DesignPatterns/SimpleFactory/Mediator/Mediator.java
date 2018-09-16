package com.pwq.DesignPatterns.SimpleFactory.Mediator;

import java.util.ArrayList;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:05 2017/11/2
 * @Modified By：
 */
public abstract class Mediator {
    protected ArrayList<Colleague> colleagues;
    public void register(Colleague colleague){
        colleagues.add(colleague);
    }
    public abstract void operation();
}
