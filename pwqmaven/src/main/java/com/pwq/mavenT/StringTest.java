package com.pwq.mavenT;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BF100500 on 2017/3/28.
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "we are students";
        int size = str.indexOf("e");
        System.out.println(size);
        int last = str.lastIndexOf("e");
        System.out.println(last);
        //获取指定索引位置的字符
        System.out.println(str.charAt(11));
        //获取子字符串
        System.out.println(str.substring(3));
        System.out.println(str.substring(0,3));
        //判断字符串的开始和结尾
        System.out.println(str.startsWith("w"));
        System.out.println(str.endsWith("d"));
        Pattern pattern = Pattern.compile("\\d+abc");
        Matcher matcher=pattern.matcher("234abc");
//        System.out.println(matcher.find());
//        System.out.println(matcher.groupCount());
        while(matcher.find()){
            System.out.println("o");
            for(int i=0;i<matcher.groupCount();i++){
                System.out.println((matcher.group(i)));
            }
        }
        }
    }
