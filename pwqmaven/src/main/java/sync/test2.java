package sync;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pwq.utils.RegexUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 11:16 2017/11/15
 * @Modified By：
 */
public class test2 {
    public static void main(String[] args) throws InterruptedException {

        String js = "{\"model\":{\"serviceBean\":{\"BEGIN_TIME\":\"20171101\",\"END_TIME\":\"20171131\",\"JSONFlag\":\"JSON_SUCCESS\",\"actBegin\":1511176906338,\"actEnd\":1511176906693,\"bossBegin\":1511176906435,\"bossEnd\":1511176906693,\"bossReason\":\"\",\"res_content\":\"{\\\"ROOT\\\":{\\\"HEADER\\\":{\\\"ENDUSRLOGINKE\\\":\\\"18843825917\\\",\\\"DB_ID\\\":\\\"A2\\\",\\\"KEEP_LIVE\\\":\\\"\\\",\\\"TRACE_ID\\\":\\\"-1\\\",\\\"CHANNEL_ID\\\":\\\"02\\\",\\\"ENDUSRLOGINID\\\":\\\"4E13F1FECDF06D65D612457630202341\\\",\\\"SUB_TRACE_ID\\\":\\\"\\\",\\\"CONTACT_ID\\\":\\\"022017112000001510689799270\\\",\\\"ENDUSRIP\\\":\\\"172.21.0.1\\\",\\\"ROUTING\\\":{\\\"ROUTE_KEY\\\":\\\"10\\\",\\\"ROUTE_VALUE\\\":\\\"18843825917\\\"},\\\"ENV_ID\\\":\\\"1\\\",\\\"PARENT_CALL_ID\\\":\\\"543B4BEDB84999E74F2ACF74FCB7692E\\\",\\\"USERNAME\\\":\\\"vvvvvv\\\",\\\"PASSWORD\\\":\\\"Exfa4Hqt\\/F4=\\\",\\\"POOL_ID\\\":\\\"31\\\"},\\\"BODY\\\":{\\\"OUT_DATA\\\":{\\\"DETAIL_INFO\\\":[{\\\"COUNT\\\":19,\\\"DETAIL_MSG\\\":[\\\"18843825917|11月03日 14:07:07|1K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月03日 16:08:13|2K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月03日 18:18:55|174K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.050|0.050|\\\",\\\"18843825917|11月03日 20:29:34|3K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月04日 10:46:59|6K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月04日 14:05:13|1K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月04日 16:10:57|1K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月04日 18:18:09|7K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月04日 20:26:29|3K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月04日 22:55:03|1K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月05日 10:58:18|12K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月06日 08:32:08|1K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.010|0.010|\\\",\\\"18843825917|11月06日 08:34:45|1K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月06日 08:36:13|245K|G网流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海||0.070|0.070|\\\",\\\"18843825917|11月06日 08:36:14|2K|4G流量|CMNET|国内(不含港澳台)漫游|前向定向-腾讯视频|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月06日 08:38:53|480K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.130|0.130|\\\",\\\"18843825917|11月20日 13:38:39|4K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月20日 16:07:10|5K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.000|0.000|\\\",\\\"18843825917|11月20日 18:07:58|12K|4G流量|CMNET|国内(不含港澳台)漫游|CMNET流量|上海|4G飞享套餐8元（新）(不结转)|0.010|0.010|\\\"],\\\"HEAD_INFO\\\":\\\"手机号码|话单时间|流量|网络类型|话单APN|漫游类型|话单类型|通信地点|优惠信息|通信费|小计|\\\"}]},\\\"RETURN_CODE\\\":\\\"0\\\",\\\"RETURN_MSG\\\":\\\"OK\\\",\\\"USER_MSG\\\":\\\"OK\\\",\\\"DETAIL_MSG\\\":\\\"OK\\\",\\\"PROMPT_MSG\\\":\\\"OK\\\",\\\"RUN_IP\\\":\\\"10.162.200.89\\\"}}}\",\"serviceType\":\"3303\",\"websaleslogClass\":\"1\"}}}";
        String startTime = RegexUtils.matchValue("BEGIN_TIME:(.*?),",js.replaceAll("\\s+","").replace("\"",""));
        String endTime = RegexUtils.matchValue("END_TIME:(.*?),",js.replaceAll("\\s+","").replace("\"",""));
        String year = startTime.substring(0,4);
        System.out.println(timeT(startTime));
        System.out.println(timeT(endTime));
        Object o = new Object();
        String a = "pwqpwq";
        User user = new User();
        System.out.println(user.hashCode());


        a=null;
        Thread.sleep(100000);
        //手机号码|话单时间|流量|网络类型|话单APN|漫游类型|话单类型|通信地点|优惠信息|通信费|小计
        String tmp = RegexUtils.matchValue("DETAIL_MSG:\\[(.*?)\\],",js.replaceAll("\\s+","").replace("\\\"",""));
        String[] tmp2 = tmp.split(",");
        for(String s:tmp2){//每一条记录
            String[] content = s.split("\\|");
            System.out.println(content[0]);//时间
            System.out.println(content[1]);//时间
            System.out.println(content[2]);//流量大小KB
            System.out.println(content[3]);//网络类型
            System.out.println(content[7]);//地点
            System.out.println(content[5]);//短信费(元)
            System.out.println(content[10]+"haha");


            System.out.println(s);
        }
        System.out.println(tmp);



    }

    public static String timeT(String time){
        try{
            return time.substring(0,4)+"-"+time.substring(4,6)+"-"+time.substring(6,8);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }


}
