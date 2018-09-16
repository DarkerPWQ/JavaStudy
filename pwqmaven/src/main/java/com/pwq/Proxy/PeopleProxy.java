package com.pwq.Proxy;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 11:11 2017/9/7
 * @Modified By：
 */
public class PeopleProxy implements Ipeople {
    private Ipeople target;

    public PeopleProxy(Ipeople target){
        this.target = target;
    }
    @Override
    public void skill() {
        System.out.println("开始");
        target.skill();
        System.out.println("结束");

    }
}
