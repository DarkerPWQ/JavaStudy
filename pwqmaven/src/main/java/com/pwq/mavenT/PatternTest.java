package com.pwq.mavenT;
import com.pwq.utils.RegexUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by BF100500 on 2017/3/17.
 */
public class PatternTest {
    public static void main(String[] args) {
//        String reg = "星级：(.*?)</span>";
//        String temp = "{\"aHtml\":\"<tr><td ><div style='float:left;'>本期费用合计</div><div style='margin-right: 10px; text-align: right; width: 65px; float: left;'>4.05</div><div style='float:left;'>元</div><br/><div style='float:left;'>本期已付费用</div><div style='margin-right: 10px; text-align: right; width: 65px; float: left;'>4.05</div><div style='float:left;'>元</div><br/><div style='float:left;'>本期应付费用</div><div style='margin-right: 10px; text-align: right; width: 65px; float: left;'>0.00</div><div style='float:left;'>元</div><div style='margin:0 5px 0 20px;float:left;'>=</div><div style='margin-right: 10px; text-align: right; width: 65px; float: left;'>4.05</div><div style='float:left;'>元(本期费用合计)</div><div style='margin:0 5px 0 20px;float:left;'>-</div><div style='margin-right: 10px; text-align: right; width: 65px; float: left;'>4.05</div><div style='float:left;'>元(本期已付费用)</div><br/></td></tr><tr><td ><span>备注：账单支付请登欢go网(sd.189.cn)或翼支付网站(www.bestpay.com.cn)使用充值卡或银行卡进行充值交费。</span></td></tr>\",\"topHtml\":\"<tr style='height:25px;text-align: left;'><td style='width:300px;'>地址:山东山东省青岛市李沧区东山三路4号104户</td><td style='width:300px;text-indent:12px;font-weight:bold;'>用电子账单,享数字生活!</td></tr><tr style='height:43px;text-align: left;'><td style='width:300px;'>姓名:张根</td><td style='width:300px;'>您可以登录欢go网(sd.189.cn)查询电子账单，电子账单也将按月发送到您的189邮箱</td></tr>\",\"jf\":\"<tr><td colspan='7' style='font-weight:bold;'>积分信息</td></tr><tr style='text-align:center;'><td width='20%'>本期末可用积分</td><td width='8%'>=</td><td width='20%'>上期末可用积分</td><td width='6%'>-</td><td width='20%'>本期使用积分</td><td width='6%'>+</td><td width='20%'>本期新增积分</td></tr><tr style='text-align:center;'><td width='20%'>0</td><td width='8%'>=</td><td width='20%'>0</td><td width='6%'>-</td><td width='20%'>0</td><td width='6%'>+</td><td width='20%'>0</td></tr><tr><td width='28%' colspan='2'>备注:年末到期积分<span>0</span></td><td width='72%' colspan='5'>积分兑换请登录欢go网(sd.189.cn)或天翼积分商城(jf.ct10000.com)。</td></tr>\",\"headImgFlag\":\"-1\",\"resultCode\":\"POR-0000\",\"pay\":\"4.05\",\"recentSixList\":[[\"12\",\"0.00\"],[\"01\",\"0.00\"],[\"02\",\"0.00\"],[\"03\",\"0.00\"],[\"04\",\"1.60\"],[\"05\",\"4.05\"]],\"html\":\"<table class='com_table' style='text-align: left; border-collapse: collapse; margin: 0px; border: 2px solid rgb(95, 223, 223);'><tr><td style='padding:0; border:0;width:50%; vertical-align:top;'><table style='width:100%;'><tr style='font-weight:bold'><td width='75%'>费用项目</td><td width='25%'>金额/元</td><tr><td  colspan='2' style='height:36; valign:top; text-align:center;font-weight:bold;'><span>4G易通卡3元（套外0.15元/分钟，赠来显）</span></td></tr><tr><td colspan='2'><span class='toptitle_kfc'>用户号码: 手机:18953251964</span><span class='pricebills'></span></td></tr><tr><td style='font-weight:bold;'><span class='toptitle_kfc billindent'>套餐及叠加包月基本费</span></td><td><span class='pricebills'></span></td></tr><tr><td><span class='toptitle_kfc billindent1'>套餐月基本费</span></td><td><span class='pricebills' style='float:left;'>3.00</span></td></tr><tr><td style='font-weight:bold;'><span class='toptitle_kfc billindent'>套餐及叠加包超出费用</span></td><td><span class='pricebills'></span></td></tr><tr><td style='font-weight:bold;'><span class='toptitle_kfc billindent1'>语音通信费</span></td><td><span class='pricebills'></span></td></tr><tr><td><span class='toptitle_kfc billindent2'>国内漫游费</span></td><td><span class='pricebills' style='float:left;'>1.05</span></td></tr><tr><td><span class='toptitle_kfc billfont13px'>本项小计：</span></td><td><span class='pricebills' style='font-weight:bold;float:left;'><strong>4.05</strong></span></td></tr></table></td><td style='width:50%;vertical-align:top; padding:0;'><table style='width:100%;'><tr style='font-weight:bold'><td width='75%'>费用项目</td><td width='25%'>金额/元</td></tr></table></td></tr></table>\",\"monthList\":[[\"语音通信费\",\"1.05\"]],\"userHtml\":\"<table style='border-collapse:collapse; border:2px #5FDFDF solid; cellpadding:0; cellspacing:0; margin:0; text-align:left;' class='com_table'><tr><td colspan='2' style='text-align:center;'><span style='font-size:20px;font-weight:600; '>中国电信股份有限公司山东电信分公司客户账单</span></td></tr><tr><td style='width:50%'><span >客户名称：张根</span></td><td><span style='text-indent: 12px; font-weight: bold;'>费用提示: 本月帐单已结清,无需再缴费.</span></td></tr><tr><td><span >计费账期：2017/05/01-2017/05/31</span></td><td rowspan='2'></td></tr><tr><td><span >打印时间：2017/06/22 16:54:06</span></td></tr></table>\"}";
//        temp = temp.replaceAll("<.*?>","").replace("\\s+","");
//        temp = "300=220-0+0";
//        System.out.println(temp.substring(0,temp.indexOf("=")));
//        System.out.println(temp.substring(temp.indexOf("=")+1,temp.indexOf("-")));
//        System.out.println(temp);
//        String temp = "安徽省马鞍山市111<span>";
//        String reg = "(.*?市).*?<span>";
//        Matcher m = Pattern.compile(reg).matcher(temp);
//        while (m.find()) {
//            System.out.println("ok");
//            System.out.println(m.group(1));
//        }
//        reg = "<tr class=\"detail talk\" id=\"talk\">\\s+<th>\\s+<p class.*?>(.*?)\n";
//        if(temp.contains("\r")){
//            System.out.println("\\n");
//        }
//        Matcher m = Pattern.compile(reg).matcher(temp);
//        while (m.find()) {
//            System.out.println(m.group(1));
//        }

//        temp = "pw q" +
//                "gwt";
//        System.out.println(temp);
//        System.out.println(temp.length());
//        temp = "pwqll g\nwt";
////        temp = "pwqgwt";
//        System.out.println(temp);
//        System.out.println(temp.length());
//        System.out.println(temp.replaceAll("\\s+",""));
//        System.out.println(temp.replaceAll("\\s+","").length());
//        System.out.println("--------");
//        reg = "pwq\\s+(.*?)g";
////        temp = temp.replace("\n","");
////        System.out.println(temp);
////        System.out.println(temp.length());
////        System.out.println(temp.replace("\r","").length());
////        System.out.println(temp.replace("\n",""));
//        Matcher m = Pattern.compile(reg).matcher(temp);
//        while (m.find()) {
//            System.out.println("ok");
//            System.out.println(m.group(1).length());
//        }
//        Pattern p1=Pattern.compile("\\d+");
//        String[] str=p1.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
//        System.out.println(str.length);
//        System.out.println(str[1]);

//        Pattern p2=Pattern.compile("\\d+");
//        Matcher m=p2.matcher("22bb23");
//        System.out.println(m.pattern());
//        Pattern p3=Pattern.compile("\\d+");
//        Matcher m1=p3.matcher("22bb23");
//        System.out.println(m1.matches());//返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.
//        System.out.println(m1.lookingAt());
//        Matcher m2=p3.matcher("bb2223");
//        System.out.println(m2.matches());//返回true,因为\d+匹配到了整个字符串
//        System.out.println(m2.lookingAt());
//        Pattern p=Pattern.compile("\\d+");
//        Matcher m=p.matcher("22bb23");
//        //find()对字符串进行匹配,匹配到的字符串可以在任何位置.
//        m.find();//返回true
//        Matcher m2=p.matcher("aa2223");
//        m2.find();//返回true
//        Matcher m3=p.matcher("aa2223bb");
//        m3.find();//返回true
//        Matcher m4=p.matcher("aabb");
//        m4.find();//返回false
//        Pattern p=Pattern.compile("\\d+");
//        Matcher m=p.matcher("aaa2223bb");
//        m.find();//匹配2223
//        m.start();//返回3
//        m.end();//返回7,返回的是2223后的索引号
//        m.group();//返回2223
//        Pattern p=Pattern.compile("[a-z]+\\d+");
//        Matcher m=p.matcher("aaa2223bb");
//        System.out.println(m.groupCount());
//        System.out.println(m.group(1));
//        System.out.println(m.group(2));

//      String patternStr = "(\\d{8})";
//        Pattern pattern = Pattern.compile(patternStr);
//        String source = "12345678wwwwwwwwww66666666";
//        Matcher matcher = pattern.matcher(source);
//        System.out.println(matcher.groupCount());
//        while (matcher.find()) {
//            System.out.println("ok");
//            for (int i = 0; i < matcher.groupCount(); i++) {
//                System.out.println(matcher.group(i + 1));
//        Pattern p = Pattern.compile("\\d+");
//        Matcher m2 = p.matcher("我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com");
//        while (m2.find()) {
//            System.out.println(m2.group());
//            //这里m.find遍历
//        }
        String string = "我叫濮文强123";
        String result = RegexUtils.matchValue("[\\u4e00-\\u9fa5]+",string);
        System.out.println(result);

    }
}

