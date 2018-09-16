package com.pwq.mavenT;

import com.pwq.utils.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 15:16 2018/1/2
 * @Modified By：
 */
public class Timecomp {
    public static void main(String args[]) {
        int i= compare_date("1995-11-12 15:21:22", "1999-12-11 09:59");
        System.out.println("i=="+i);
        System.out.println(DateUtils.getCompareDate("2018-11-12 15:21:22"));

        System.out.println("2022".compareTo("2018"));
    }

    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = new Date();
            System.out.println(dt2.getTime());
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
