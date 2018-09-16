package com.pwq.DesignPatterns.SimpleFactory.ServiceS;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 11:21 2017/11/3
 * @Modified By：
 */
public class TestStatic {
    public static int a = 0;
    static {// Step 1
        a = 10;
        System.out.println("静态代码块在执行a=" + a);
    }

    {// Step 4
        a = 8;
        System.out.println("非静态代码块（构造代码块）在执行a=" + a);
    }

    public TestStatic() {
        this("调用带参构造方法1，a=" + a); // Step 2
        System.out.println("无参构造方法在执行a=" + a);// Step 7
    }

    public TestStatic(String n) {
        this(n, "调用带参构造方法2，a=" + a); // Step 3
        System.out.println("带参构造方法1在执行a=" + a); // Step 6
    }

    public TestStatic(String s1, String s2) {
        System.out.println(s1 + "；" + s2);// Step 5
    }

    public static void main(String[] args) {
        TestStatic t = null;// JVM加载Test类，静态代码块执行
        System.out.println("下面new一个Test实例：");
        t = new TestStatic();
    }

}
