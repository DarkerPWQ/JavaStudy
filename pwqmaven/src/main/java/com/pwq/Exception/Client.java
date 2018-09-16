package com.pwq.Exception;

import org.apache.http.conn.ConnectTimeoutException;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 18:51 2017/12/8
 * @Modified By：
 */
public class Client {
    public static void main(String[] args) throws ConnectTimeoutException {
        Aexpection aexpection = new Aexpection();
        aexpection.setID("2");
    }
}
