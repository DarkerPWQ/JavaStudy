package com.pwq.mavenT;

import java.io.*;

/**
 * Created by BF100500 on 2017/6/26.
 */
public class UseStudent {
    public static void main(String[] args) {
        Student st = new Student("tom",'m',20,3.6);
        File file = new File("D://student.txt");
        try{
            file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        //对象序列化
        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(st);
            oos.flush();;
            oos.close();;
            fos.close();

            //反序列化
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student st1 = (Student) ois.readObject();
            System.out.println(st1);


        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e ){
            e.printStackTrace();
        }

    }


}
