package com.pwq.mavenT;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by BF100500 on 2017/7/24.
 */
public class RedisTest {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        jedis.set("runoobkey", "www.runoob.com");
        System.out.println("redis 字符串为： " + jedis.get("runoobkey"));
        jedis.lpush("site-list", "java");
        jedis.lpush("site-list", "python");
        jedis.lpush("site-list", "c++");
        List<String> list = jedis.lrange("site-list", 0, 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("列表项为:" + list.get(i));
        }
        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key);

        }
    }
}
