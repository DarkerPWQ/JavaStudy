package com.pwq.mavenT;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

/**
 * Created by BF100500 on 2017/7/24.
 */
public class GsonTest {
    public static void main(String[] args) {
    Gson gson  = new Gson();
    Student student = new Student();
    student.setName("濮文强");
    student.setSex('n');
    System.out.println("简单对象之间的转化");
    String s1 = gson.toJson(student);
        JSONObject jsonObject = JSONObject.parseObject(s1);
        System.out.println(jsonObject.toString());
        System.out.println("简单的bean转化为json"+s1);
        Student student1 = gson.fromJson(s1,Student.class);
        System.out.println("json转化为简单Bean"+student1);

    }
}
