package com.pwq.Exception;

import org.apache.http.conn.ConnectTimeoutException;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 16:00 2017/9/14
 * @Modified By：
 */
public class Aexpection  {
    private String id;
    public void setID(String id) throws ConnectTimeoutException
    {   t();
        if(id.length() == 7)
        {
            this.id = id;
        }
        else
        {

        }
    }
    public void t(){
        System.out.println("里");
//        throw new ConnectTimeoutException("来了");
//        throw new RuntimeException("ja");

    }
}
