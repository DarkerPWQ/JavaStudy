package com.pwq.mavenT;

import com.pwq.utils.Base64;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

/**
 * Created by BF100500 on 2017/6/27.
 */
public class UrlCode {
    public static void main(String[] args) {
        try{
            String strTest = "jsonParam=%5B%7B%22dynamicParameter%22%3A%7B%22method%22%3A%22sendSmsMessage%22%2C%22handleNum%22%3A%22defaultHandle%22%2C%22applyNum%22%3A%22smsCodeValidateCDS%22%2C%22smsCheck%22%3A%22%22%2C%22type%22%3A1%2C%22oppPhone%22%3A%7B%7D%2C%22detailType%22%3A%7B%7D%2C%22beginDate%22%3A%7B%7D%2C%22endDate%22%3A%7B%7D%7D%2C%22dynamicDataNodeName%22%3A%22loginCallBackActionNode%22%7D%5D";
//            System.out.println(strTest.replace("6","2"));
            System.out.println("---------");
            strTest = "银行信用卡";
            strTest = URLEncoder.encode(strTest, "UTF-8");
            System.out.println(strTest);
            strTest = String.format("jsonParam=[{\"dynamicParameter\":{\"method\":\"sendSmsMessage\",\"handleNum\":\"defaultHandle\",\"applyNum\":\"smsCodeValidateCDS\",\"smsCheck\":\"\",\"type\":1,\"oppPhone\":{},\"%s\":{},\"beginDate\":{},\"endDate\":{}},\"dynamicDataNodeName\":\"loginCallBackActionNode\"}]","xxxxx");
            System.out.println(strTest);

            MessageDigest md5= MessageDigest.getInstance("MD5");
            System.out.println(Base64.encode(md5.digest(strTest.getBytes("utf-8"))));
            //三目运算符的学习
            String a  = "pwq"=="pwq"?"":"no";
            int i  = 0;
            //do--while
            do{
                System.out.println("执行");
                i+=1;
            }while(i<5);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
