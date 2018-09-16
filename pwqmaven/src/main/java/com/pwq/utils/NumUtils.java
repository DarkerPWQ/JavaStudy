package com.pwq.utils;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:29 2017/9/28
 * @Modified By：
 */
public class NumUtils {

    /**
     * @Author: WenqiangPu
     * @Description: 将字符串型整数转化为int。
     * @param str
     * @return:
     * @Date: 10:35 2017/9/28
     */
    public static int parseInt(String str){
        if(StringUtils.isEmpty(str)){
            return 0;
        }
        boolean isNum = str.matches("[0-9]+");
        if(isNum){
            return Integer.parseInt(str);
        }
        return 0;
    }

    /**
     * @Author: WenqiangPu
     * @Description: 将字符串浮点型转化为浮点型
     * @param str
     * @return:
     * @Date: 15:25 2017/9/28
     */
    public static double parseDouble(String str){
        if(StringUtils.isEmpty(str)){
            return 0;
        }
        boolean isNum = str.matches("^[-\\+]?[0-9]+\\.?[0-9]*$");
        if(isNum){
            return Double.parseDouble(str);
        }
        return 0;
    }
    /**
     * @Author: WenqiangPu
     * @Description: 将字符串金额(单位元)转化为int类型以分为单位
     * @param money
     * @return:
     * @Date: 15:34 2017/9/28
     */
    public static int parseMoney(String money){

        return (int)(NumUtils.parseDouble(money) * 100);
    }
    public static Double parseMoney2(String money){
        return NumUtils.parseDouble(money) * 100;
    }
}
