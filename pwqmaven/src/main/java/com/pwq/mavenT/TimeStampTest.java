package com.pwq.mavenT;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 11:11 2017/7/27
 * @Modified By：
 */
public class TimeStampTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(new Date().getTime());
        System.out.println(stampToDate(System.currentTimeMillis()));
        System.out.println(System.currentTimeMillis()/1000);
    }
    /**
     * @Author: WenqiangPu
     * @Description: 将时间戳转化为时间
     * @param s
     * @return:
     * @Date: 11:17 2017/7/27
     */
    public static String stampToDate(Long s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long lt = new Long(s);
        Date date = new Date(lt);
        return simpleDateFormat.format(date);

    }
}
