package com.pwq.mavenT;

import com.alibaba.fastjson.JSONObject;
import com.pwq.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by BF100500 on 2017/3/20.
 */
public class loggingTest
{   private static final Logger log = LoggerFactory.getLogger(MapTest.class);
    public static void main(String[] args) {
        try{
            String content  = "pwq";


            JSONObject jsonObject = JSONObject.parseObject(content);
        }catch (Exception e){
            log.info("==>[{}]解析出错了", "pwq", e);
        }
        log.info("pwpq");
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
        String year = DateUtils.getCurrentYear();
        System.out.println("WebAccounts/codeMaker?t="+new Date());



    }


}
