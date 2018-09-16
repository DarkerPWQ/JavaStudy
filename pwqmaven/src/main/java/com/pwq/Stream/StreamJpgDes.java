package com.pwq.Stream;

import java.io.*;

/**
 * Created by pwq on 2018/1/15.
 */
public class StreamJpgDes {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("示例图片_copy11.jpg"));
        BufferedOutputStream bufferedOutputStreamn = new BufferedOutputStream(new FileOutputStream("示例图片_copy12.jpg"));
        int b = 0;
        while((b = bufferedInputStream.read())!=-1){
            bufferedOutputStreamn.write(b^123);
        }
        bufferedInputStream.close();
        bufferedOutputStreamn.close();

    }
}
