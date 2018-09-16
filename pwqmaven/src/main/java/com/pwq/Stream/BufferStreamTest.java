package com.pwq.Stream;

import org.junit.Test;

import java.io.*;

/**
 * Created by pwq on 2018/1/14.
 */
public class BufferStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("示例图片_02.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream  = new FileOutputStream("示例图片copybuff.jpg");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int b = 0;
        while((b=bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(b);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();

    }
    public void CloseAndFlush() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("示例图片_02.jpg"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("示例图片copyflush.jpg"));
        int b = 0;
        while((b=bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(b);
        }
        //不关闭的情况：close具备刷新的功能，在关闭流之前，会帅新一次缓冲区，将缓冲区的字节流全都刷新到文件中区
    }
    @Test
    public void BufferT() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("pom.xml"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("pwq.xml"));
        int x ;
        while((x=bf.read())!=-1){
            bw.write(x);
        }
        bf.close();
        bw.close();
    }

    @Test
    public void BufferT1() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("pom.xml"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("pwq.xml"));
        String line ;
        while((line=bf.readLine())!=null){
            System.out.println(line);
        }
        bf.close();
        bw.close();
    }






}
