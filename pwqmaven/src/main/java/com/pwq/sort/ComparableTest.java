package com.pwq.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 20:14 2017/8/2
 * @Modified By：
 */
public class ComparableTest {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setName("pwq");
        user1.setOrder(2);
        User user2 = new User();
        user2.setName("gwt");
        user2.setOrder(3);
        List<User> list = new ArrayList();
        list.add(user1);
        list.add(user2);
        Collections.sort(list);
        for(User u:list){
            System.out.println(u.getName());
        }
    }
}
