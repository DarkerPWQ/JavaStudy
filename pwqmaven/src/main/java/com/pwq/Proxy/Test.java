package com.pwq.Proxy;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 15:56 2017/9/7
 * @Modified By：
 */
public class Test {
    public static void main(String[] args) {
        Ipeople ipeople = new People();
//        PeopleProxy peopleProxy = new PeopleProxy(ipeople);
//        Ipeople peopleProxy = (Ipeople) new ProxyFactory(ipeople).InstanceProxy();
//        System.out.println(peopleProxy.getClass());
        User user = new User();
        User userProxy = (User) new CgilbProxy(user).getInstance();
        userProxy.name();
    }


}
