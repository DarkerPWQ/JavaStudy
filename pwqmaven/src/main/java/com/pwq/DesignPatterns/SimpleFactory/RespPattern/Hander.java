package com.pwq.DesignPatterns.SimpleFactory.RespPattern;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 13:52 2017/10/19
 * @Modified By：
 */
public abstract class Hander {
    protected Hander hander;

    public Hander(Hander hander) {
        this.hander = hander;
    }
    public abstract String request(LeaveRequest leaveRequest);

}
