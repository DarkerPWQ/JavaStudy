package com.pwq.mavenT;

import org.junit.*;


/**
 * Created by BF100500 on 2017/7/24.
 */
public class BytesTest {
    public static void main(String[] args) {
        try{
            byte[] b_utf8 = "中".getBytes("UTF-8");
            System.out.println(b_utf8);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
@org.junit.Test
    public void print(){
        String a="";
        if(null==a||a.equals("")){
            System.out.println("null or 空");
        }else {
            System.out.println("正常");
        }
//    System.out.println(Math.floor(3.8));
//    向上取整:Math.ceil()   //只要有小数都+1
//    向下取整:Math.floor搜索()   //不取小数
//    四舍五入:Math.round()  //四舍五入
    System.out.println(Math.ceil(6.3));
    System.out.println(Math.floor(6.3));
    System.out.println(Math.round(6.3));
    System.out.println(((Object)Math.ceil(6.5)).getClass().toString());


    }
}
//</editor-fold>
