package com.pwq.Stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by pwq on 2018/1/18.
 */
public class ByteArrayOs {
    public static void main(String[] args) throws IOException {
        FileInputStream fis =new FileInputStream("pom.xml");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int b;
        while((b=fis.read())!=-1){
            baos.write(b);//将读取的文件都存到内存中去。
        }
        byte[] arr = baos.toByteArray();
        System.out.println(new String(arr));
        System.out.println(baos.toString());
        fis.close();


    }
}
