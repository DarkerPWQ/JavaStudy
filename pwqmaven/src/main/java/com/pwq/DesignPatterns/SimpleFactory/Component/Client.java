package com.pwq.DesignPatterns.SimpleFactory.Component;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:00 2017/10/12
 * @Modified By：
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("start");
        //对叶子文件操作的模拟
//        Component component = new Leaf("我是文件");
//        component.add(new Leaf("haha"));
//        component.remove(new Leaf("xixi"));
//        component.operation();
        //对容器文件操作的模拟
        Component component = new Composite("我是文件夹");
        component.add(new Leaf("haha"));
        component.remove(new Leaf("xixi"));
        component.add(new Composite("wjj"));
        component.operation();


    }
}
