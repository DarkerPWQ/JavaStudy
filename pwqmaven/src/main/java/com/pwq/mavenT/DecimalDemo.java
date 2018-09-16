package com.pwq.mavenT;

import com.pwq.utils.StringUtils;

import java.math.BigDecimal;

/**
 * Created by BF100500 on 2017/3/23.
 */
public class DecimalDemo {
    public static void main(String[] args) throws IllegalAccessException {
//        System.out.println(Integer.parseInt("11"));
//        System.out.println(0.06+0.01);
//        System.out.println(1.0-0.42);
        System.out.println(Math.random());//就算把小数位处理完，也是不精确的4014.9999999999995
        System.out.println(Double.parseDouble("4.015")*1000);//就算把小数位处理完，也是不精确的4014.9999999999995
//        System.out.println(303.1/1000);
//        System.out.println(4.015*100);
//
//        System.out.println(Double.parseDouble("22.334")*100+Double.parseDouble("23.43")*100);
//        System.out.println(22.334+23.432);
//        System.out.println(Integer.parseInt("22"));
//        System.out.println(new BigDecimal("100.12"));
//        System.out.println(new BigDntln(Double.parseDouble("22.334")*100+Double.parseDouble("23.43")*100);
//        System.out.println(22.334+23.432);
//        System.out.println(Integer.parseInt("22"));
//        System.out.println(new BigDecimal("100.12"));
//        System.out.println(new BigDntln(Double.parseDouble("22.334")*100+Double.parseDouble("23.43")*100);
//        System.out.println(22.334+23.432);
//        System.out.println(Integer.parseInt("22"));
//        System.out.println(new BigDecimal("100.12"));
//        System.out.println(new BigDntln(Double.parseDouble("22.334")*100+Double.parseDouble("23.43")*100);
//        System.out.println(22.334+23.432);
//        System.out.println(Integer.parseInt("22"));
//        System.out.println(new BigDecimal("100.12"));
//        System.out.println(new BigDntln(Double.parseDouble("22.334")*100+Double.parseDouble("23.43")*100);
//        System.out.println(22.334+23.432);
//        System.out.println(Integer.parseInt("22"));
//        System.out.println(new BigDecimal("100.12"));
//        System.out.println(new BigDecimal("jj"));
//        System.out.println(new BigDecimal(Double.valueOf(100.12)));
//        System.out.println(Double.parseDouble("0.48"));
//        System.out.println(add(Double.parseDouble("0.48"),Double.parseDouble("0.24")));
//        int i = parseInt("3.5");
//         i = parseInt("pwq");
//         i = parseInt("50");
//         i = parseInt("");
//        double d = parseDouble("3.5");
//        d = parseDouble("pwq");
//        d = parseDouble("50");
//        d = parseDouble("");
//        d = parseDouble("0.33");
//        d = parseDouble("33.33");
        System.out.println(add(0.48,0.24));
        System.out.println(div(42.633,2,1));
        System.out.println();


    }
    public static double add(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        System.out.println(b1.add(b2).getClass());
        return b1.add(b2).doubleValue();

    }

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

    public static double div(double value1,double value2,int scale) throws IllegalAccessException{
            //如果精确范围小于0，抛出异常信息
            if(scale<0){
                    throw new IllegalAccessException("精确度不能小于0");
                }
            BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
            BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
            return b1.divide(b2, scale).doubleValue();
        }
}
