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
 * @date: 2016-07-30 16:07
 * @version: v1.0
 */
public class FormatMUtils {

	protected static Logger logger= LoggerFactory.getLogger(FormatUtils.class);

    /**
     * @Description:格式化钱相关数据、
     * @param @param money
     * @return  格式：【100/100.00】
     * */
    public static String FormatMoney(String money){

        try{
            
            if(StringUtils.isBlank(money)){
                return "";
            }

            String retMoney = money;
            retMoney = retMoney.replaceAll(" ", "");
            retMoney = retMoney.replaceAll(",", "");

            //去掉【元】
            if(retMoney.contains("元")){
                retMoney = retMoney.replaceAll("元", "");
            }

            //去掉【万】
            if(retMoney.contains("万")){
                retMoney = retMoney.replaceAll("万", "");

                //去掉【万】以后判断是否是浮点类型、
                if(StringUtils.isFloat(retMoney)){
                    BigDecimal bigDecimalA =new BigDecimal(retMoney);
                    BigDecimal bigDecimalB = new BigDecimal("10000");
                    bigDecimalA = bigDecimalA.multiply(bigDecimalB);
                    retMoney = bigDecimalA.toString();
                }
                //记录错误转化日志
                else{
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
     * @Description:格式化日期、只保留月份
     * @param @param retDate
     * @param @param bDay
     *
     * @return
     *      bDay：false ==》格式：【yyyy-mm】
     *      bDay：true ==》格式：【yyyy-mm-dd】
     * */
    public static String FormatDate(String date, boolean bDay){

        try{
            
            if(StringUtils.isBlank(date)){
                return "";
            }
            
            String retDate = date.trim();
              
            //mm[-/]dd[ HH:mm:ss]
            if(Pattern.compile("^\\d{2}[-/]\\d{2}[ \\d{2}:\\d{2}:\\d{2}]").matcher(retDate).find()){

                retDate = retDate.replaceAll("/", "-");
                String year = DateUtils.getCurrentYear();
                if(bDay) retDate = year + "-" + retDate.substring(0,5);
                else  retDate = year + "-" + retDate.substring(0,2);

            }
            //yyyy[-/年]m[-/月][dd[日][ HH:mm:ss]]
            else if(Pattern.compile("^\\d{4}[-/年]\\d{1,2}[[-/月]\\d{1,2}[日]?[ \\d{2}:\\d{2}:\\d{2}]?]?").matcher(retDate).find()){
                if(retDate.contains("年") && retDate.contains("月")){

                    retDate = retDate.replace("年", "-").replace("日", "");

                    //判断月是否是最后一个字符
                    boolean bLastMonth = retDate.indexOf("月") == retDate.length()-1 ? true :false;
                    if(bLastMonth){
                        retDate = retDate.replace("月", "");
                    }
                    else{
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

            }
            //yyyymm[dd]
            else if(Pattern.compile("^\\d{6}[\\d{2}]*$").matcher(retDate).find()){
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
    
    public static String moneyZerofill(String money){
    	if(StringUtils.isBlank(money)){
             return "";
        }
    	 
    	try {
    		money = money.replace(",", "");
        	DecimalFormat df=new DecimalFormat("######################.00");
     		BigDecimal bd=new BigDecimal(money);
     		String val=df.format(bd);
     		return val.startsWith(".")?"0"+val:val;
		} catch (Exception e) {
			 logger.info("格式化转换异常：" + money);
	         return  money;
		}
    	
    }

    public static String FormatAccStatus(String status) {
    	
    	if(StringUtils.isBlank(status)) {
    		return "";
    	}
    	
    	if(StringUtils.contains(status, "正常")) {
    		return "正常";
    	} else if(StringUtils.contains(status, "封存")) {
    		return "封存";
    	} else if(StringUtils.contains(status, "销户")) {
    		return "销户";
    	} else {
    		return status;
    	}
    }

    /**
     * unicode 转字符串
     */
    public static String unicode2String(String unicode) {

        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);

            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }
}
