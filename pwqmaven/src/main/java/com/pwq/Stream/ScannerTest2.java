package com.pwq.Stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by pwq on 2018/1/15.
 */
public class ScannerTest2 {
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        System.out.println("请开始输入数据，回车键录入，quit退出");
        BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(new FileOutputStream("test.txt"));
        while(true){
            String line = sc.nextLine();
            if("quit".equals(line)){
                break;
            }else{
                bufferedOutputStream.write(line.getBytes());
                System.out.println("录入成功");
            }
        }
        sc.close();
        bufferedOutputStream.close();
    }
}
