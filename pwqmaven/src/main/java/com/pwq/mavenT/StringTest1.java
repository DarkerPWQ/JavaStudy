package com.pwq.mavenT;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:12 2017/12/1
 * @Modified By：
 */
public class StringTest1 {
    static final int MAX = 100000;
    static final String[] arr = new String[MAX];
    public static void main(String[] args) {
//        String s0 = "kvill";
//        String s1 = "kvill";
//        String s2 = "kv" + "ill";//到底经历了什么,通过编译器优化
//        System.out.println(s0 == s1);
//        System.out.println(s0 == s2);
//        System.out.println(s1 == s2);


//        String s0="kvill";
//        String s1=new String("kvill");//组合方式
//        String s2="kv" + new String("ill");
//        s1 = s1.intern();//这种底层是实现是去找s1是否在字符串常量池中有对象引用，有的话就是该引用，没有就创建再返回。
//        System.out.println( s0==s1 );
//        System.out.println( s0==s2 );
//        System.out.println( s1==s2 );

        //

//        String s0= "kvill";
//        String s1=new String("kvill");
//        String s2=new String("kvill");
//        System.out.println( s0==s1 );//fa
//        System.out.println( "**********" );
//        s1.intern();
//        s2=s2.intern(); //把常量池中"kvill"的引用赋给s2
//        System.out.println( s0==s1);//fa
//        System.out.println( s0==s1.intern() );//tr
//        System.out.println( s0==s2 );//tr


        //
//        String s1=new String("kvill");
//        String s3=new String("kvill");
//        System.out.println(s1.intern()==s3.intern());//true
//        String s2=s1.intern();
//        System.out.println( s1==s1.intern() );//fa
//        System.out.println( s1+" "+s2 );
//        System.out.println( s2==s1.intern() );//tr

//        String str1 = new String("SEU")+ new String("Calvin");//算字面量
//        System.out.println(str1.intern() == str1);
//        System.out.println(str1 == "SEUCalvin");

//        String str2 = "SEUCalvin";//新加的一行代码，其余不变
//        String str1 = new String("SEU")+ new String("Calvin");
//
//        System.out.println(str2==str1);//是fa，说明并不是完全的字面量
//        System.out.println(str1.intern() == str2);
//        System.out.println(str1 == "SEUCalvin");
//        System.out.println(str2 == "SEUCalvin");
//        System.out.println(str2 == str1.intern());
//
//        System.out.println(str1.equals(str2));


//        String s = new String("1");
//        s.intern();
//        String s2 = "1";
//        System.out.println(s == s2);
//
//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        System.out.println(s3.intern() ==s3);
//        System.out.println("11" ==s3);
//        String s4 = "11";
//        System.out.println(s3 == s4);
//        System.out.println();



//        String s1 = new String("PW")+new String("Q");
//        s1.intern();
//        String s2 = new String("PWQ");
//
//
//        System.out.println(s1.intern()==s2.intern());//
//        System.out.println(s1==s1.intern());
//        System.out.println(s2==s1);
//        System.out.println(s2==s2.intern());//
//        System.out.println(s1==s2.intern());//
//        System.out.println(s2==s2.intern());
//        System.out.println(s2==s1.intern());
//        System.out.println(s1==s1.intern());


//        String str1 = new String("SEU") + new String("Calvin");
//        System.out.println(str1.intern() == str1);
//        System.out.println(str1 == "SEUCalvin");

//        String s1 = "Hello";
//        String s2 = "Hello";
//        String s3 = "Hel" + "lo";
//        String s4 = "Hel" + new String("lo");
//        String s5 = new String("Hello");
//        String s6 = s5.intern();
//        String s7 = "H";
//        String s8 = "ello";
//        String s9 = s7 + s8;
//        System.out.println(s1==s9);
//        String a = "pwq";
//        String b = String.valueOf("pwq");//相当“pwq”
//        System.out.println(a==b);
        //为长度为10的Integer数组随机赋值
//        while(true){
//            Integer[] sample = new Integer[10];
//            Random random = new Random(1000);
//            for (int i = 0; i < sample.length; i++) {
//                sample[i] = random.nextInt();
//            }
//            //记录程序开始时间
//            long t = System.currentTimeMillis();
//            //使用/不使用intern方法为10万个String赋值，值来自于Integer数组的10个数
//            for (int i = 0; i < MAX; i++) {
////            arr[i] = new String(String.valueOf(sample[i % sample.length]));
//                arr[i] = new String(String.valueOf(sample[i % sample.length])).intern();
//            }
//            System.out.println((System.currentTimeMillis() - t) + "ms");
////            System.gc();
//        }



    }
}
