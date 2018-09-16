package com.pwq.again;

import com.pwq.utils.DateUtils;
import com.pwq.utils.RegexUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 18:41 2017/8/1
 * @Modified By：
 */
public class ThreadTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String string = "pwqgthhaha";
        String[] tmp = RegexUtils.matchMutiValue("pwq(.*?)hh(.*?)b",string);
        System.out.println(tmp.length);
        System.out.println(DateUtils.getCurrentDate());
        System.out.println("0".equals(0)+"");



    }
}
