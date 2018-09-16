package com.pwq.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pwq.utils.Base64;
import com.pwq.utils.DateUtils;
import com.pwq.utils.RegexUtils;
import com.pwq.utils.TimeTran;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:48 2017/11/1
 * @Modified By：
 */
public class test1 {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        A e = new B();

        System.out.println("1--" + a1.show(b));//show(A obj)--return ("A and A");
        System.out.println("2--" + a1.show(c));//show(A obj)   return ("A and A");
        System.out.println("3--" + a1.show(d));//return ("A and D");
        System.out.println("4--" + a2.show(b));//return B and A
        System.out.println("5--" + a2.show(c));//return B and A
        System.out.println("6--" + a2.show(d));//return ("A and D");
        System.out.println("7--" + b.show(b));//return ("B and B");;
        System.out.println("8--" + b.show(c));//return ("B and B");--
        System.out.println("9--" + b.show(d));//return ("A and D");

        System.out.println(e.show(b));
    }

}
class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }

}

class B extends A{
    public String show(B obj){
        return ("B and B");
    }

    @Override
    public String show(A obj){
        return ("B and A");
    }
}

class C extends B{

}

class D extends B{

}