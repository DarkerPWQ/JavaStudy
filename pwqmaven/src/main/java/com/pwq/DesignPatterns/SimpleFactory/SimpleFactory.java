package com.pwq.DesignPatterns.SimpleFactory;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:50 2017/9/19
 * @Modified By：
 */
public class SimpleFactory {
    public static TV getInstance(String name){
        if("hx".equals(name)){
            return new HXTv();
        }else if("lg".equals(name)){
            return new LGTv();
        }
        return null;
    }

}
