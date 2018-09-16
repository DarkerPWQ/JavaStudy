package com.pwq.mavenT;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BF100500 on 2017/3/22.
 */
public class copy {
    public static void main(String[] args) {
        List<Integer> tmp = new ArrayList();
        for(int i=0;i<10;i++){
            tmp.add(i);
        }
        System.out.println("start");
        for(Integer j:tmp){
            System.out.println(j);
            tmp.add(j);
        }
    }



}
