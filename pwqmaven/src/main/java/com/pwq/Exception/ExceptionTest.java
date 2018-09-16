package com.pwq.Exception;

import java.nio.channels.ConnectionPendingException;

/**
 * Created by pwq on 2017/9/14.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try{
            System.out.println(Double.parseDouble("0.32a"));
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("我是大的catch");
        }catch (ConnectionPendingException e){
            e.printStackTrace();
            System.out.println("我曹，发横了异常");
        }

        System.out.println("到底有没有执行到这一步");
    }

    public static void tran() throws NumberFormatException{
        String a = "abc";
        System.out.println(1/0);
        System.out.println("4444444");

    }
    public static void pwq(String a ){
        if(a.endsWith("pwq")){

//            sout
            System.out.println("pwq'");
        }

    }
}
