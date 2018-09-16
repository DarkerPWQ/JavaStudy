package com.pwq.mavenT;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by BF100500 on 2017/3/27.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,String> maps = new HashMap();
        //填入
//        maps.put("username","濮文强");
//        maps.put("sex","男");
//        maps.put("address","安徽");
        System.out.println(maps.get("jsjs"));

        //第一种遍历 entrySet
        for(Map.Entry<String,String> entry:maps.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        //第二种遍历
        //显示调用map.entrySet的集合迭代器
Iterator<Map.Entry<String,String>> iterator = maps.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        //利用keyset
        for(String key:maps.keySet()){
            System.out.println(key);
            System.out.println(maps.get(key));
        }



    }
}
