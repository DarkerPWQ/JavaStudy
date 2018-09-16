package com.pwq.Stream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by pwq on 2018/1/14.
 */
public class StreamReadCh {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("pwq.txt");
        byte[] b=new byte[1024];
        int len=0;
        while((len = fileInputStream.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }

    }
}
