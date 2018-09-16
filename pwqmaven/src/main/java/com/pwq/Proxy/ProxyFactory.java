package com.pwq.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 16:02 2017/9/7
 * @Modified By：
 */
public class ProxyFactory {
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object InstanceProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始");
                Object object = method.invoke(target,args);
                System.out.println("结束");
                return null;
            }
        });
    }
}
