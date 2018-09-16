package com.pwq.DesignPatterns.SimpleFactory.ServiceS;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:09 2017/11/3
 * @Modified By：
 */
public class Services {//服务提供者模式
    private static Services services;
    private static HashMap<String,Provider> provides =new HashMap<>();

    static {
        System.out.println("加载开始");
        Services.reg("A",new Aprovider());
        Services.reg("B",new Bprovider());
        System.out.println("加载完成");
    }

    private Services(){};
    public static Services getInstance(){
        if(services==null){//可以有操作
            services=new Services();
        }
        return services;
    }
    public static void reg(String name,Provider provider){
        provides.put(name,provider);
    }
    public static Service getService(String name) throws Exception {
        if(provides.containsKey(name)){
            return provides.get(name).proService();
        }else{
            throw  new Exception("没有这个服务不好意思");
        }
    }
}
