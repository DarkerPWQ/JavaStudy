package com.pwq.Test;


import com.pwq.utils.*;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 16:27 2017/10/18
 * @Modified By：
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException, AssertionError {

//        System.out.println((char)36890);
//        String url = "\\u901A\\u7528\\u4F59\\u989D";
//        System.out.println(decodeUnicode(url));
//        System.out.println(getMoney("￥50元"));
        String logFlag = String.format("我叫%s%s","文强","hja");
        final String month = "2012";
        char t = '你';
        System.out.println((int)t);
        System.out.println((char)((int)t));
    }

    public static int getMoney(String money){
        String[] tmp = money.replace("元","").split("￥");
        if(tmp.length>1){
            return NumUtils.parseMoney(tmp[1].replace(" ",""));
        }else{
            return 0;
        }
    }
    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }

}

