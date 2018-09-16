package com.pwq.mavenT;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pwq.utils.DateUtils;
import com.pwq.utils.RegexUtils;
import com.pwq.utils.StringUtils;

import java.util.Calendar;

/**
 * Created by BF100500 on 2017/6/5.
 */
public class JsonTest {
    public static void main(String[] args) {
        System.out.println(tranI("1小时"));

    }
    public static int tranI(String time){
        try{
            if(StringUtils.isNotEmpty(time)){
                String[] durs = time.replace("小时",":").replace("时",":").replace("分",":").replace("秒",":").split(":");
                int dur = 0;
                if(durs.length == 3){
                    dur += Integer.parseInt(durs[0]) * 3600;
                    dur += Integer.parseInt(durs[1]) * 60;
                    dur += Integer.parseInt(durs[2]);
                }
                if(durs.length == 2){
                    dur += Integer.parseInt(durs[0]) * 60;
                    dur += Integer.parseInt(durs[1]);
                }
                if(durs.length == 1){
                    if(time.contains("小时")||time.contains("时")){
                        dur += Integer.parseInt(durs[0]) * 3600;
                    }else if(time.contains("分")){
                        dur += Integer.parseInt(durs[0]) * 60;
                    }else{
                        dur += Integer.parseInt(durs[0]);
                    }
                }
                return dur;//通话时长(单位:秒)
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

}
