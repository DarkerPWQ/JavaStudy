package com.pwq.Exception;

import org.apache.http.conn.ConnectTimeoutException;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 14:39 2017/9/25
 * @Modified By：
 */
public class Bexception extends Aexpection {
    public void setID(String s){
        System.out.println(s);
        System.out.println("重写异常还在吗");
    }
}
