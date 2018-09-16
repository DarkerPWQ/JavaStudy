package com.pwq.DesignPatterns.SimpleFactory.ServiceS;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:50 2017/11/3
 * @Modified By：
 */
public class Bprovider implements Provider {
    @Override
    public Service proService() {
        return new Bservice();
    }
}
