package com.pwq.DesignPatterns.SimpleFactory.Fmethod;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 11:38 2017/9/19
 * @Modified By：
 */
public class LgFactory implements IFactory {
    @Override
    public TV getInstance() {
        return new LGTv();
    }
}
