package sync.neipac;

import sync.User;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 21:38 2017/11/22
 * @Modified By：
 */
public class test1 {
    public static void main(String[] args) {
////        User user = new User();
////        user.setUsername("文强");
//        System.out.println(user);
//        t(user);
//        System.out.println(user);
        String s = "我是被修改之前的";
        t1(s);
        System.out.println(s);
    }
    public static String t(User user){
        System.out.println("正在进行修改呢");
        user.setPasswd("123456");

        return "ok";
    }

    public static String t1(String s){
        System.out.println("正在进行修改呢");
        s="被修改过";

        return "ok";
    }
}
