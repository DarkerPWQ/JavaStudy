package com.pwq.Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by pwq on 2018/1/14.
 */
public class StreamTry {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream=new FileInputStream("pwq.txt");
        FileOutputStream fileOutputStream=new FileOutputStream("pwq2.txt");
        int b = 0;
        while((b=fileInputStream.read())!=-1){
            fileOutputStream.write(b);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }
}
