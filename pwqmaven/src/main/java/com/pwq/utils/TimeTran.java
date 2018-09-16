package com.pwq.utils;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 13:44 2017/9/18
 * @Modified By：
 */
public class TimeTran {
    /**
     * @Author: WenqiangPu
     * @Description: 将 00小时00分00秒与 00时00分00秒时间格式转化为以秒为单位
     * @param time
     * @return:
     * @Date: 14:37 2017/9/28
     */
    public static String tran(String time){
        try{
            if (StringUtils.isNotEmpty(time)) {
                String hour = RegexUtils.matchValue("(\\d+).*?时", time);
                String min = RegexUtils.matchValue("(\\d+)分", time);
                String sec = RegexUtils.matchValue("(\\d+)秒", time);
                int finalDuration = 0;
                if (StringUtils.isNotBlank(hour)) {
                    finalDuration = Integer.parseInt(hour) * 3600;
                }
                if (StringUtils.isNotBlank(min)) {
                    finalDuration += Integer.parseInt(min) * 60;
                }
                if (StringUtils.isNotBlank(sec)) {
                    finalDuration += +Integer.parseInt(sec);
                }
                return finalDuration + "";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "0";
    }


    /**
     * @Author: WenqiangPu
     * @Description: 将 00小时00分00秒与 00时00分00秒时间格式转化为以秒为单位(int类型)
     * @param time
     * @return:
     * @Date: 18:14 2017/10/31
     */
    public static int tranToInt(String time){
        return Integer.parseInt(tran(time));
    }


    /**
     * @Author: WenqiangPu
     * @Description: 将00:00:00 时间格式转化为以秒为单位*（int类型）
     * @param time
     * @return:
     * @Date: 16:06 2017/10/11
     */
    public static int tranI(String time) {
        try {
            if (StringUtils.isNotEmpty(time)) {
                String[] tmp = time.split(":");
                String hour = "";
                String min = "";
                String sec = "";
                if (tmp.length > 2) {//标准格式
                    hour = tmp[0];
                    min = tmp[1];
                    sec = tmp[2];
                } else if (tmp.length > 1 && tmp.length < 3) {
                    min = tmp[0];
                    sec = tmp[1];
                } else {
                    sec = tmp[0];
                }
                int finalDuration = 0;
                if (StringUtils.isNotBlank(hour)) {
                    finalDuration = Integer.parseInt(hour) * 3600;
                }
                if (StringUtils.isNotBlank(min)) {
                    finalDuration += Integer.parseInt(min) * 60;
                }
                if (StringUtils.isNotBlank(sec)) {
                    finalDuration += +Integer.parseInt(sec);
                }
                return finalDuration;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }



    /**
     * @Author: WenqiangPu
     * @Description: 流量转化为Kb
     * @param flow
     * @return:
     * @Date: 16:16 2017/10/11
     */
    public static int tranFlow(String flow){
        try{
            if (StringUtils.isNotEmpty(flow)) {
                String gb = RegexUtils.matchValue("([0-9]*\\.?[0-9]*)G|g", flow);
                String mb = RegexUtils.matchValue("([0-9]*\\.?[0-9]*)M|m", flow);
                String kb = RegexUtils.matchValue("([0-9]*\\.?[0-9]*)K|k", flow);
                int flowKb = 0;
                if (StringUtils.isNotBlank(gb)) {
                    flowKb +=Double.parseDouble(gb) * 1048576;
                }
                if (StringUtils.isNotBlank(mb)) {
                    flowKb +=Double.parseDouble(mb) * 1024;
                }
                if (StringUtils.isNotBlank(kb)) {
                    flowKb +=Double.parseDouble(kb);
                }
                return flowKb;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }






    /**
     * @Author: WenqiangPu
     * @Description: 将 00小时00分00秒与 00时00分00秒时间格式转化为以秒为单位(int类型)
     * @param time
     * @return:
     * @Date: 17:46 2017/11/8
     */
    public static int timeToSec(String time){
        int finalDuration = 0;
        try{
            //首先判断time是什么格式 00(小)时00分00秒与 00:00:00
            if(StringUtils.contains(time,":")){//00:00:00
                String[] tmp = time.split(":");
                String hour = "";
                String min = "";
                String sec = "";
                if (tmp.length ==3) {//标准格式
                    hour = tmp[0];
                    min = tmp[1];
                    sec = tmp[2];
                } else if (tmp.length ==2) {
                    min = tmp[0];
                    sec = tmp[1];
                } else if(tmp.length ==1) {
                    sec = tmp[0];
                }

                if (StringUtils.isNotBlank(hour)) {
                    finalDuration = Integer.parseInt(hour) * 3600;
                }
                if (StringUtils.isNotBlank(min)) {
                    finalDuration += Integer.parseInt(min) * 60;
                }
                if (StringUtils.isNotBlank(sec)) {
                    finalDuration += +Integer.parseInt(sec);
                }
            }else{//00(小)时00分00秒
                String hour = RegexUtils.matchValue("(\\d+).*?时", time);
                String min = RegexUtils.matchValue("(\\d+)分", time);
                String sec = RegexUtils.matchValue("(\\d+)秒", time);
                if (StringUtils.isNotBlank(hour)) {
                    finalDuration = Integer.parseInt(hour) * 3600;
                }
                if (StringUtils.isNotBlank(min)) {
                    finalDuration += Integer.parseInt(min) * 60;
                }
                if (StringUtils.isNotBlank(sec)) {
                    finalDuration += +Integer.parseInt(sec);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return finalDuration;
    }
}
