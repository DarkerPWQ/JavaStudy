package com.pwq.mavenT;

/**
 * Created by BF100500 on 2017/3/17.
 */
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.pwq.utils.Base64;
import com.pwq.utils.RegexUtils;

import static com.pwq.utils.PageHelper.getPage;

public class Test {

        public static void main(String[] args) {
            try{
                WebClient webclient = new WebClient();
                Page page = webclient.getPage("http://www.ip138.com/post/search.asp?action=zone2area&zone=0555 ");
                System.out.println(RegexUtils.matchValue("查询结果.*?<tr>(.*?)</tr>",page.getWebResponse().getContentAsString().replaceAll("\\s+","")));
                String city = RegexUtils.matchValue("查询结果.*?<tr>(.*?)</tr>",page.getWebResponse().getContentAsString().replaceAll("\\s+","")).replaceAll("<.*?>","").replace("◎","").replace("&nbsp;"," ");
                System.out.println(city);
                String[] list = city.split(" ");
                if(list[2].contains("市")){
                    System.out.println(list[2]);
                }else{
                    System.out.println(list[1]);
                }

// 这里是配置一下不加载css和javaScript,配置起来很简单，是不是

                webclient.getOptions().setCssEnabled(false);

                webclient.getOptions().setJavaScriptEnabled(false);

// 做的第一件事，去拿到这个网页，只需要调用getPage这个方法即可
                String url = "http://pic.58pic.com/58pic/13/75/13/01e58PICgPY_1024.jpg";

//                HtmlPage page = webclient.getPage("http://pic.58pic.com/58pic/13/75/13/01e58PICgPY_1024.jpg");
                page = getPage(webclient, url, HttpMethod.GET, null, null);
                System.out.println(Base64.getBase64ByImgInputStream(page.getWebResponse().getContentAsStream()));

//                System.out.println("ober");
//                List<HtmlElement> itElem = (List<HtmlElement>) page.getByXPath("//input[contains(@name,'lt')]");
//                String reportNo = itElem.get(0).getAttribute("value");

//                final HtmlForm form = htmlpage.getFormByName("f");
//
//// 同样道理，获取”百度一下“这个按钮
//
//                final HtmlSubmitInput button = form.getInputByValue("百度一下");
//
//// 得到搜索框
//
//                final HtmlTextInput textField = form.getInputByName("q1");
//
//// 最近周星驰比较火呀，我这里设置一下在搜索框内填入”周星驰“
//
//                textField.setValueAttribute("周杰伦");
//
//// 输入好了，我们点一下这个按钮
//
//                final HtmlPage nextPage = button.click();
//
//// 我把结果转成String
//
//                String result = nextPage.asXml();
//
//                System.out.println(result);
            }catch (Exception e){
                System.out.println(e);
            }

        }
    }
