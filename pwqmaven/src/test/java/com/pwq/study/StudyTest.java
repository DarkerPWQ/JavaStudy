package com.pwq.study;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by BF100500 on 2017/7/11.
 */
public class StudyTest {


    public StudyTest() {
        System.out.println("鄙人构造器");
    }

    @Test
    public void test(){
        StringBuilder startDateNew = new StringBuilder ("pwqagwt1314ysys");
        System.out.println(startDateNew.insert(10, " ").toString());//上网时间，格式：yyyy-MM-dd HH:mm:ss
        System.out.println(2178.31*3);
    }
    @Test
    public void test1(){
        System.out.println("gwt");
    }

    @After
    public void test11(){
        System.out.println("执行方法前");
    }

    @Before
    public void test111(){
        System.out.println("执行方法后");
    }
}
