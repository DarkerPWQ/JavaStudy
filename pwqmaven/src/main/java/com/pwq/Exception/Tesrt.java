package com.pwq.Exception;

import org.apache.http.conn.ConnectTimeoutException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 16:06 2017/9/14
 * @Modified By：
 */
public class    Tesrt {
    public static void main(String[] args) {
        try {
            List list = new ArrayList<>();
            throw new ConnectTimeoutException();

//            Aexpection aexpection = new Bexception();
//            aexpection.setID("pwq");
//            System.out.println("我啥也没做，能不能catch异常");
//            Boolean flag = false;
//            do{
//                for(int i=0;i<10;i++){
//                    System.out.println(i);
//                     if(i==5){
//                         flag=true;
//                         break;
//                     }
//                }
//            }while (!flag);
//            System.out.println("chul;ai");

        }catch (ConnectTimeoutException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            System.out.println("hehe");
        }catch (ArithmeticException ex){//可以直接catch，这个异常是runtime的
            System.out.println("ArithmeticException");
            ex.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
