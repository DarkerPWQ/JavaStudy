package com.pwq.utils;

import java.util.Calendar;

/**
 * Created by pwq on 2017/10/13.
 */
public class Transform{

    private static String str= "我被创建"+ Calendar.getInstance().getTimeInMillis();
    public static void print(){
        System.out.println(str);
    }


}
