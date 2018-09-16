package com.pwq.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * @Description:格式化数据
 * @author: york
 * @date: 2016-09-26 18:26
 * @version: v1.0
 */
public class FormatUtils {

	protected static Logger logger= LoggerFactory.getLogger(FormatUtils.class);

    private FormatUtils() {
        throw new AssertionError();
    }

    /**
     * 将字符串换成BigDecimal
     * @param money
     * @return 无法转换时返回 0
     */

    public static BigDecimal formatBigDecimal(String money) {
        BigDecimal bigDecimal = new BigDecimal(0);
        try{
            if(StringUtils.isNotEmpty(money)){
                bigDecimal = new BigDecimal(money);
            }
        }catch (Exception e){
            logger.info("==>数字转换出错:", e);
        }
        return bigDecimal;
    }
    
    /**
     * 将字符串金额转换成BigDecimal
     * @param money
     * @return 无法转换时返回 0
     */
    public static BigDecimal formatBmoney(String money){
        try{
            if(StringUtils.isBlank(money)){
                return new BigDecimal(0);
            }
            BigDecimal factor = new BigDecimal(1);
            money = money.replaceAll(" ", "");
            money = money.replaceAll(",", "");
            money = money.replaceAll("元/月", "");
            money = money.replaceAll("￥", "");
            money = money.replaceAll("元", "");
            //去掉【万】
            if(money.contains("万")) {
                money = money.replaceAll("万", "");
                factor = factor.multiply(new BigDecimal(10000));
            }

            BigDecimal bigDecimal = new BigDecimal(money);
            return bigDecimal.multiply(factor);
        }catch (Exception e){
            logger.info("==>金额转换出错:", e);
        }
        return new BigDecimal(0);
    }
    /**
     * 将字符串金额转换成BigDecimal
     * 单位由元变成分
     * @param money
     * @return 无法转换时返回 0
     */
    public static BigDecimal formatMoney2Fen(String money){
        try{
            if(StringUtils.isBlank(money)){
                return new BigDecimal(0);
            }
            BigDecimal bigDecimal = formatBmoney(money);
            return bigDecimal.multiply(new BigDecimal(100));
        }catch (Exception e){
            logger.info("==>金额转换出错:", e);
        }
        return new BigDecimal(0);
    }

    /**
     * @Description:格式化钱相关数据
     * @param @param money
     * @return  格式：【100/100.00】
     * */
    public static String formatMoney(String money){
        try{
            if(StringUtils.isBlank(money)){
                return "";
            }

            String retMoney = money;
            retMoney = retMoney.replaceAll(" ", "");
            retMoney = retMoney.replaceAll(",", "");
            retMoney = retMoney.replaceAll("元/月", "");
            retMoney = retMoney.replaceAll("￥", "");
            retMoney = retMoney.replaceAll("元", "");

            //去掉【万】
            if(retMoney.contains("万")){
                retMoney = retMoney.replaceAll("万", "");

                //去掉【万】以后判断是否是浮点类型、
                if(StringUtils.isFloat(retMoney)){
                    BigDecimal bigDecimalA =new BigDecimal(retMoney);
                    BigDecimal bigDecimalB = new BigDecimal("10000");
                    bigDecimalA = bigDecimalA.multiply(bigDecimalB);
                    retMoney = bigDecimalA.toString();
                }else{
                    return money;
                }
            }
            retMoney = moneyZerofill(retMoney);
            return retMoney;

        }catch (Exception ex){
        	logger.info("格式化转换异常：" + money);
            return  money;
            
        }
    }

    /**
     * 保留二位小数
     * @param money
     * @return
     */
    public static String moneyZerofill(String money){
    	if(StringUtils.isBlank(money)){
             return "";
        }
    	try {
    		money = money.replace(",", "");
        	DecimalFormat df = new DecimalFormat("######################.00");
     		BigDecimal bd=new BigDecimal(money);
     		String val=df.format(bd);
     		return val.startsWith(".")?"0"+val:val;
		} catch (Exception e) {
			 logger.info("格式化转换异常：" + money);
	         return  money;
		}
    	
    }

    /**
     * @Description:格式化日期
     * @param @param retDate
     * @param @param bDay
     *
     * @return
     *      bDay：false ==》格式：【yyyy-mm】
     *      bDay：true ==》格式：【yyyy-mm-dd】
     * */
    public static String formatDate(String date, boolean bDay){
        try{
            if(StringUtils.isBlank(date)){
                return "";
            }
            String retDate = date.trim();
            retDate = retDate.replace("日", " 日").replace("时", "").replace("分","").replace("秒","");

            //mm[-/]dd[ HH:mm:ss]
            if(Pattern.compile("^\\d{2}[-/]\\d{2}[ \\d{2}:\\d{2}:\\d{2}]").matcher(retDate).find()){
                retDate = retDate.replaceAll("/", "-");
                String year = DateUtils.getCurrentYear();
                if(bDay) retDate = year + "-" + retDate.substring(0,5);
                else  retDate = year + "-" + retDate.substring(0,2);

            }else if(Pattern.compile("^\\d{4}年[\\d{1}]$").matcher(retDate).find()){
                if(bDay) retDate = retDate.substring(0,4) + "-0"+ retDate.substring(5,6)+ "-01";
                else retDate = retDate.substring(0,4) + "-0"+ retDate.substring(5,6);
            }else if(Pattern.compile("^\\d{4}[-/年]\\d{1,2}[[-/月]\\d{1,2}[日]?[ \\d{2}:\\d{2}:\\d{2}]?]?").matcher(retDate).find()){
                if(retDate.contains("年") && retDate.contains("月")){

                    retDate = retDate.replace("年", "-").replace("日", "");

                    //判断月是否是最后一个字符
                    boolean bLastMonth = retDate.indexOf("月") == retDate.length()-1 ? true :false;
                    if(bLastMonth){
                        retDate = retDate.replace("月", "");
                    }else{
                        retDate = retDate.replace("月", "-");
                    }

                    //2011-01|2011-1
                    if(retDate.length() < 8){
                        retDate = retDate + "-01";
                    }
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    retDate = format.format(format.parse(retDate));
                }
                if(bDay) retDate =retDate.length() >= 10 ? retDate.substring(0,4) + "-"+ retDate.substring(5,7)  + "-" + retDate.substring(8,10):retDate.substring(0,4) + "-"+ retDate.substring(5,7)  + "-01";
                else  retDate = retDate.substring(0,4) + "-"+ retDate.substring(5,7) ;

            }else if(Pattern.compile("^\\d{6}[\\d{2}]*$").matcher(retDate).find()){
                if(bDay) retDate = retDate.length() >= 8 ? retDate.substring(0,4) + "-"+ retDate.substring(4,6)+ "-"+ retDate.substring(6,8): retDate.substring(0,4) + "-"+ retDate.substring(4,6)+ "-01";
                else retDate = retDate.substring(0,4) + "-"+ retDate.substring(4,6);
            }

            //判断格式是否匹配、不匹配则记录日志文件
            if(!Pattern.compile("^\\d{4}-\\d{2}-\\d{2}").matcher(retDate).find() && !Pattern.compile("^\\d{4}-\\d{2}").matcher(retDate).find()){
                //记录日志
                return date;
            }
            return retDate;
        }catch (Exception ex){
            logger.info("格式化转换异常：" + date);
            return  date;
        }
    }

    /**
     * 将日期转换为yyyy-MM-dd
     * yyyyMMdd ==> yyyy-MM-dd
     * yyyy年MM月dd日 ==> yyyy-MM-dd
     * yyyy年M月d日 ==> yyyy-MM-dd
     * yyyy MM dd ==> yyyy-MM-dd
     * @param date
     * @return
     */
    public static String formatStringDate(String date){
        if(StringUtils.isNotEmpty(date)){
            date = date.trim();
            date = date.replaceAll("年","-");
            date = date.replaceAll("月","-");
            date = date.replaceAll("日","");
            date = date.replaceAll(" ","");

            StringBuilder sb = new StringBuilder();
            if(date.indexOf("-")<0){
                if(sb.length()>6) {
                    sb.append(date);
                    sb.insert(4, "-");
                    sb.insert(7, "-");
                }
            }else{
                String[] tmps = date.split("-");
                if(null != tmps && tmps.length > 2){
                    if(2 == tmps[0].length()){
                        sb.append("20"+tmps[0]);
                    }else{
                        sb.append(tmps[0]);
                    }
                    sb.append("-");
                    if(1 == tmps[1].length()){
                        sb.append("0"+tmps[1]);
                    }else{
                        sb.append(tmps[1]);
                    }
                    sb.append("-");
                    if(1 == tmps[2].length()){
                        sb.append("0"+tmps[2]);
                    }else{
                        sb.append(tmps[2]);
                    }
                }
            }
            if(sb.length()>9) {
                sb.delete(10, sb.length());
            }
            return sb.toString();
        }
        return date;
    }

    /**
     * 将日期转换为yyyy-MM
     * yyyyMMdd ==> yyyy-MM
     * @param date
     * @return
     */
    public static String formatStringMonth(String date){
        if(StringUtils.isNotEmpty(date)){
            StringBuilder sb = new StringBuilder(formatStringDate(date));
            if(4 != date.indexOf("-")){
                if(sb.length()>5) {
                    sb.insert(4, "-");
                }
            }
            if(sb.length()>6) {
                sb.delete(7, sb.length());
            }
            return sb.toString();
        }
        return date;
    }

    /**
     * 将日期转换为yyyy
     * yyyyMMdd ==> yyyy
     * @param date
     * @return
     */
    public static String formatStringYear(String date){
        if(StringUtils.isNotEmpty(date)){
            StringBuilder sb = new StringBuilder(date);
            if(sb.length()>4) {
                sb.delete(4, sb.length());
            }
            return sb.toString();
        }
        return date;
    }

    /**
     * 时间转化成秒
     * @param time
     * @return
     */
    public static String formatSecondLength(String time) {
        String retValue = "";
    	if(StringUtils.isBlank(time)) {
    		return "";
    	}
        try {
            time = time.replaceAll("小时", ":").replaceAll("时", ":").replaceAll("分", ":").replaceAll("秒", "");
            if (Pattern.compile("^\\d+:\\d+:\\d+$").matcher(time).find()) {
                String[] arr = RegexUtils.matchMutiValue("^(.*?):(.*?):(.*?)$", time);
                if (arr.length == 3) {
                    retValue = String.valueOf(Integer.parseInt(arr[0]) * 3600 + Integer.parseInt(arr[1]) * 60 + Integer.parseInt(arr[2]));

                }
            } else if (Pattern.compile("^\\d+:\\d+$").matcher(time).find()) {
                String[] arr = RegexUtils.matchMutiValue("^(.*?):(.*?)$", time);
                if (arr.length == 2) {
                    retValue = String.valueOf(Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]));
                }
            } else if (Pattern.compile("\\d+$").matcher(time).find()) {
                String[] arr = RegexUtils.matchMutiValue("^(.*?)$", time);
                if (arr.length == 1) {
                    retValue = String.valueOf(Integer.parseInt(arr[0]));
                }
            }
            //检验转化是否成功
            if (!Pattern.compile("\\d+$").matcher(retValue).find()) {
                return time;
            }
        }catch (Exception e) {
            logger.info("格式化转换异常：" + time);
            return  time;
        }
        return retValue;
    }

    /**
     * @Author: WenqiangPu
     * @Description: 流量转化为Kb   1Gb200Mb100Kb==>1*1024*1024+200*1024+100
     * 200M100K==>200*1024+100
     * 100K==>100
     * @param flow
     * @return:
     * @Date: 16:16 2017/10/11
     */
    public static int flowToKb(String flow){
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
