package com.pwq.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 15:08 2017/9/13
 * @Modified By：
 */
public class ReflectTest {
    public static void main(String[] args)throws Exception {
        try {

//            Class classc1 = Class.forName("com.pwq.mavenT.Student");
//            Object o = classc1.newInstance();
//            System.out.println(classc1);
//            Field f = classc1.getDeclaredField("name");
//            f.setAccessible(true);
//            f.set(o,"pwq");
//            System.out.println(f.getName());
//            System.out.println();
//            System.out.println(f.get(o));
            Student object = (Student) getInstance("com.pwq.reflect.Student");
            System.out.println(object);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Object getInstance(String name) throws Exception{
        Class c1 = Class.forName(name);
        Object o = c1.newInstance();
        Field f = c1.getDeclaredField("name");
        f.setAccessible(true);
        f.set(o,"pwq");
        Method m = c1.getMethod("getName");
        m.setAccessible(true);
        String s = (String) m.invoke(o);
        System.out.println(s);
        return o;
    }
}
