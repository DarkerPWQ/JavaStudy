package com.pwq.DesignPatterns.SimpleFactory.BuildePattern;

import java.util.Calendar;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 16:07 2017/9/19
 * @Modified By：
 */
public class test {
    public static void main(String[] args) {

    Director director=new Director(new MealABuild());
        System.out.println(director.getMeal());
    }
}
