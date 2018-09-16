package com.pwq.mavenT;

import java.io.FileInputStream;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 13:53 2017/7/28
 * @Modified By：
 */
public class CharTest {
    public static void main(String[] args) {
        int j =2;
        for(int i=0;i<15;i++){
            j = j*2;
        }
        System.out.println(j);
        char word = '我';
        int p = 0x9FF0;
        System.out.println("在unicode表中的顺序位置是：" + (int) word);
        System.out.println("unicode表中的第65位是：" + (char) p);


        System.out.println((byte)30);
    }
}
