package com.pwq.utils;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 11:39 2017/10/13
 * @Modified By：
 */
public class CodeUtil {
    private static WebClient webClient = new WebClient();
    private static Map<String,String> codeMap = new HashMap();
    public static String getCity(String code){
        if(codeMap.containsKey(code)){
            return codeMap.get(code);
        }
        String city = "";
        try{
            System.out.println("over");
            Page page = webClient.getPage("http://www.ip138.com/post/search.asp?action=zone2area&zone="+code);
            city = RegexUtils.matchValue("查询结果.*?<tr>(.*?)</tr>",page.getWebResponse().getContentAsString().replaceAll("\\s+","")).replaceAll("<.*?>","").replace("◎","").replace("&nbsp;"," ");
            String[] list = city.split(" ");
            if(list[2].contains("市")){
                city = list[2];
            }else{
                city = list[1];
            }
        }catch (Exception e){
            e.printStackTrace();
            city = "";
        }
        if(StringUtils.isNotEmpty(city)){
            codeMap.put(code,city);
        }
        return city;
    }

    public static void main(String[] args) {
        System.out.println(CodeUtil.getCity("021"));
        System.out.println(CodeUtil.getCity("021"));
        System.out.println(CodeUtil.getCity("0555"));
    }
}
