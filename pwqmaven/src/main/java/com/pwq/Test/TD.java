package com.pwq.Test;

import com.pwq.utils.DateUtils;

import java.util.Calendar;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 15:46 2017/12/13
 * @Modified By：
 */
public class TD {

    public static void main(String[] args) {
        System.out.println(Math.random());
        Calendar calendar = Calendar.getInstance();
        System.out.println(DateUtils.getCustomYearMont(DateUtils.PATTERN5));
//        System.out.println(test(""));
    }
    public static String test(EnumTesta enumTesta){
        return enumTesta.name();
    }



}
enum EnumTesta{//小枚举
        pwq,
        gwt;
}
