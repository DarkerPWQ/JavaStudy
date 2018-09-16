package com.pwq.mavenT;

/**
 * Created by BF100500 on 2017/7/12.
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder MyStringBuilder = new StringBuilder("pwqagwt");
        MyStringBuilder.append("day");
        System.out.println(MyStringBuilder);
        MyStringBuilder.insert(3,"1314");
        System.out.println(MyStringBuilder);
        System.out.println(MyStringBuilder.length());


    }
}
