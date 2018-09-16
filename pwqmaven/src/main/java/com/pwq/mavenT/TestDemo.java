package com.pwq.mavenT;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.pwq.utils.DateUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by BF100500 on 2017/3/21.
 */
public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(LoveEnum.青春);
        System.out.println(LoveEnum.爱情.getCode());
        System.out.println(LoveEnum.爱情.getMsg());
        System.out.println(LoveEnum.爱情.getType());
        System.out.println(LoveEnum.getMsg("青春"));
        System.out.println(LoveEnum.getCode("爱情"));
        Thread.sleep(10000);
        WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
        WebClient webClient1 = new WebClient(BrowserVersion.INTERNET_EXPLORER);
        System.out.println(webClient);
        System.out.println(webClient1);
        while(true){
            System.out.println("haha");
        }

    }
}
