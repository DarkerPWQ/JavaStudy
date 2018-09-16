package com.pwq.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 18:50 2017/9/7
 * @Modified By：
 */
class CgilbProxy implements MethodInterceptor {
    private Object target;

    public CgilbProxy(Object target) {
        this.target = target;
    }
    public Object getInstance(){
        Enhancer en = new Enhancer();
        en.setSuperclass(this.target.getClass());
        en.setCallback(this);
        return en.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始");
        Object returnValue = method.invoke(this.target,objects);
        System.out.println("结束");
        return returnValue;
    }
}
