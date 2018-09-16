package com.pwq.Stream;

import org.junit.Test;

import java.io.*;

/**
 * Created by pwq on 2018/1/13.
 */
public class SystemStreamTest {
    public static void main(String[] args) throws IOException {

        System.out.println((int)'知');
        FileInputStream fileInputStream=new FileInputStream("testFile.log");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        int i = fileInputStream.read();
        System.out.println((char)i);
        System.out.println(i);



        int j = fileInputStream.read();
        System.out.println(j);
        System.out.println((char)j);


        int x = fileInputStream.read();
        System.out.println(x);
        System.out.println((char)x);;


        int z = fileInputStream.read();
        System.out.println(z);
        System.out.println((char)z);


         z = fileInputStream.read();
        System.out.println(z);
        System.out.println((char)z);;

         z = fileInputStream.read();
        System.out.println(z);
        System.out.println((char)z);;
    }


    @Test
    public void FileInputTest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("testFile.log");
        int i = 0;
        while((i=fileInputStream.read())!=-1){
            System.out.println(i);
        }
        fileInputStream.close();
    }

    @Test
    public void FileOutputTest() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("testFileout.log");
        fileOutputStream.write(97);
        fileOutputStream.write(97);
        fileOutputStream.write(97);
        fileOutputStream.close();
    }


    @Test
    public void PhCopyTest1() throws IOException {//效率太低
        FileInputStream fileInputStream = new FileInputStream("示例图片_02.jpg");
        FileOutputStream fileOutputStream  = new FileOutputStream("示例图片copy.jpg");
        int i = 0;
        while((i=fileInputStream.read())!=-1){
            fileOutputStream.write(i);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Test
    public void PhCopyTest2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("示例图片_02.jpg");
        FileOutputStream fileOutputStream  = new FileOutputStream("示例图片copy2.jpg");
        byte[] i = new byte[1024*10];
        int len=0;
        while((len = fileInputStream.read(i))>0){
            fileOutputStream.write(i,0,len);

        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Test
    public void PhCopyTest3() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("示例图片_02.jpg");
        FileOutputStream fileOutputStream  = new FileOutputStream("示例图片copy3.jpg");
        byte[] i = new byte[fileInputStream.available()];//不推荐，太大了，内存溢出
        fileInputStream.read(i);
        fileOutputStream.write(i);
        fileInputStream.close();
        fileOutputStream.close();
    }



}
