package com.pwq.mavenT;

import org.junit.*;
import org.junit.Test;

/**
 * Created by BF100500 on 2017/7/13.
 */
public class TryTest {
    public void in(){
        try{
            System.out.println("内部的try");
            int i  = 10/0;
            System.out.println("我就不执行咯？");
        }catch (Exception e){
            System.out.println("内部的catch");
            e.printStackTrace();
        }finally {
            System.out.println("内部的finally");
        }
    }
    @Test
    public void on(){
        try{
            System.out.println("外部的try，没有异常");
            in();
//            int j = 10/0;
            System.out.println("里面有问题关我毛事啊");
        }catch (Exception e){



            System.out.println("外部的catch");
            e.printStackTrace();
        }finally {
            System.out.println("外部的finally");
        }
    }
}
