package com.pwq.mavenT;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BF100500 on 2017/4/7.
 */
public class GenericTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("pwq");
        list.add("gwt");
        list.add(110);
        for(int i=0;i<list.size();i++){
            String name = (String) list.get(i);
            System.out.println(name);
        }
    }
}
