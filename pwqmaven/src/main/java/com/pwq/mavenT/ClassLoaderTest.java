package com.pwq.mavenT;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:05 2017/12/4
 * @Modified By：
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        Class c = classLoaderTest.getClass();
        ClassLoader classLoader = c.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());

        //验证一下java.lang下的包类加载器
        classLoader = String.class.getClassLoader();
        System.out.println(classLoader);//结果和上面一样是null，到了bt都是null？
        //原因是BootstrapLoader（启动类加载器）是用C语言实现的，找不到一个确定的返回父Loader的方式。
    }
}
