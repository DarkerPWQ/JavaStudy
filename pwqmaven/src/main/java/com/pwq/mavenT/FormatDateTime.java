package com.pwq.mavenT;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by BF100500 on 2017/3/22.
 */
public class FormatDateTime {
    public static void main(String[] args) {
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat myFmt1=new SimpleDateFormat("yy/MM/dd HH:mm");

        SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等价于now.toLocaleString()
        SimpleDateFormat myFmt3=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
        SimpleDateFormat myFmt4=new SimpleDateFormat(
                "一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");
        Date now=new Date();
        System.out.println(now.getTime());
        System.out.println(now);
        System.out.println(myFmt.format(now));
        System.out.println("-------------");
        try{

            Date date = myFmt.parse("2016-12-14");
            System.out.println(date);
        }catch (ParseException e) {
            System.out.println("error");
            e.printStackTrace();
        }
//        System.out.println(myFmt.format(now).getClass());
//        System.out.println(myFmt1.format(now));
//        System.out.println(myFmt2.format(now));
//        System.out.println(myFmt3.format(now));
//        System.out.println(myFmt4.format(now));
////        System.out.println(now.toGMTString());
////        System.out.println(now.toLocaleString());
//        System.out.println(now.toString());
    }
}
