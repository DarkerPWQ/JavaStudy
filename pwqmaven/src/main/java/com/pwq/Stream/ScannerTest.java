package com.pwq.Stream;

import java.io.*;
import java.util.Scanner;

/**
 * Created by pwq on 2018/1/15.
 */
public class ScannerTest {
    public static void main(String[] args) throws IOException {
        File file = getFile();//获取文件
        BufferedInputStream bufferedInputStream =new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file.getName()));
        int b = 0;
        while((b =bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(b);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();




    }
    public static File getFile(){
        //c创建键盘录入对象 路径--》分装成File对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件路径");
        while(true){
            String line = sc.nextLine();
            File file =new File(line);
            if(!file.exists()){
                System.out.println("路径不存在思密达");
            }else if(file.isDirectory()){
                System.out.println("文件夹路径，重新输入");
            }else{
                return file;
            }

        }

    }
}
