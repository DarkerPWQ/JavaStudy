package com.pwq.mavenT;

import com.pwq.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 17:42 2017/11/16
 * @Modified By：
 */
public class BigD {
    public  String numAdd(String a,String b){
        String str="";
        int lenA=a.length();
        int lenB=b.length();
        int maxLen,minLen;
        if(lenA>lenB){
            maxLen = lenA;
            minLen = lenB;
        }else{
            maxLen = lenB;
            minLen = lenA;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<maxLen-minLen;i++){
            sb.append("0");
        }
        if(lenA==minLen){
            a=sb.append(a).toString();
        }
        else{
            b=sb.append(b).toString();
        }

        sb=new StringBuilder();
        int tmpA,tmpB,result;
        int jw=0;
        for(int i=maxLen-1;i>=0;i--){
            tmpA=Integer.valueOf(a.charAt(i)+"");
            tmpB=Integer.valueOf(b.charAt(i)+"");
            result=tmpA+tmpB+jw;
            jw=result/10;
            result=result%10;
            sb.append(result);
        }
        if(jw==1){
            sb.append("1");
        }
        str=sb.reverse().toString();
        return str;
    }

    public static void main(String[] args) {
        int x = 4;        System.out.println("value is " + ((x == 4) ? 9:99.9));
        int b=123;
            char a = (char) b;
    }
}
