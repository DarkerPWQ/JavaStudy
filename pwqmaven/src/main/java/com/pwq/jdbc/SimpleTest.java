package com.pwq.jdbc;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:52 2017/8/14
 * @Modified By：
 */
public class SimpleTest {
    private static SimpleTest instance;
    private SimpleTest(){
        System.out.println("创建");

    }
    public static final SimpleTest getInstance(){
        if(instance==null){
            instance = new SimpleTest();
        }
        return instance;
    }

    public static void main(String[] args) {
        SimpleTest s1 = SimpleTest.getInstance();
        SimpleTest s2 = SimpleTest.getInstance();
        if(s1==s2){
            System.out.println("sucess");
        }else {
            System.out.println("false");
        }
    }
}
