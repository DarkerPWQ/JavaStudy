package com.pwq.mavenT;

import com.alibaba.fastjson.util.TypeUtils;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.pwq.utils.CollectionUtil;
import com.pwq.utils.Constants;
import com.pwq.utils.EntityUtils;
import com.pwq.utils.StringUtils;
import java.net.URL;
import java.util.*;

/**
 * Created by BF100500 on 2017/4/6.
 */
public class HtmlunitTest {
    //是否允许代理
    protected static boolean enableProxy = false;
    //代理配置
    private static ProxyConfig proxyConfig = new ProxyConfig();

    private Page getPage(WebClient webClient, String url, HttpMethod httpMethod, List<NameValuePair> params,
                         CharsetCode charset, Map<String, String> header) {
        if (httpMethod == HttpMethod.GET) {
            return doGet(webClient, url, params, charset, header, "");
        } else {
            return doPost(webClient, url, params, charset, header, "");
        }
    }


    private Page getPage(WebClient webClient, String url, HttpMethod httpMethod, List<NameValuePair> params,
                         CharsetCode charset, Map<String, String> header, String bodyStr) {
        if (httpMethod == HttpMethod.GET) {
            return doGet(webClient, url, params, charset, header, bodyStr);
        } else {
            return doPost(webClient, url, params, charset, header, bodyStr);
        }
    }
    public Page getPage(WebClient webClient, String url, HttpMethod httpMethod, List<NameValuePair> params,
                        int retryTimes, String logFlag, Map<String, String> header, String bodyStr) {
        Page page;
        int rt = 1;
        while (rt <= retryTimes) {
            try {
                page = getPage(webClient, url, httpMethod, params, CharsetCode.UTF8, header, bodyStr);
                if (null != page) {
                    System.out.println("222222");
                    return page;
                } else {
                    rt++;
                }
            } catch (Exception e) {
                rt++;
            }
        }
        return null;
    }


    private Page doGet(WebClient webClient, String pageUrl, List<NameValuePair> reqParam,
                       CharsetCode charset, Map<String, String> header, String bodyStr) {
        try {
            URL url;
            if (CollectionUtil.isEmpty(reqParam)) {
                url = new URL(pageUrl);
            } else {
                url = new URL(pageUrl + "?" + EntityUtils.toString(reqParam));
            }

            WebRequest webRequest = new WebRequest(url, HttpMethod.GET);
            if (null != header) {
                for (String key : header.keySet()) {
                    webRequest.setAdditionalHeader(key, header.get(key));
                }
            }
            if (charset == null) {
                charset = CharsetCode.UTF8;
            }
            webRequest.setCharset(charset.getCode());
            if (StringUtils.isNotBlank(bodyStr)) {
                webRequest.setRequestBody(bodyStr);
            }
            return webClient.getPage(webRequest);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    private Page doPost(WebClient webClient, String pageUrl, List<NameValuePair> reqParam,
                        CharsetCode charset, Map<String, String> header, String bodyStr) {
        try {
            URL url = new URL(pageUrl);
            WebRequest webRequest = new WebRequest(url, HttpMethod.POST);
            webRequest.setAdditionalHeader("Accept-Language", "zh-CN");
            if (charset == null) {
                charset = CharsetCode.UTF8;
            }
            webRequest.setCharset(charset.getCode());
            if (reqParam != null) {
                webRequest.setRequestParameters(reqParam);
            }
            if (null != header) {
                for (String key : header.keySet()) {
                    webRequest.setAdditionalHeader(key, header.get(key));
                }
            }
            if (StringUtils.isNotBlank(bodyStr)) {
                webRequest.setRequestBody(bodyStr);
            }
            return webClient.getPage(webRequest);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    private WebClient initWebClient(WebClient webClient) {
        if (null == webClient) {
            webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
        }
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getCookieManager().setCookiesEnabled(true);
        webClient.getOptions().setActiveXNative(false);
        webClient.getOptions().setAppletEnabled(false);
        webClient.getOptions().setCssEnabled(false);// 禁用css支持
        webClient.getOptions().setThrowExceptionOnScriptError(false);// js运行错误时，是否抛出异常
        webClient.getOptions().setJavaScriptEnabled(false); //禁用JS
        webClient.getOptions().setTimeout(120000);
        if (enableProxy) {
            if (StringUtils.isNotBlank(proxyConfig.getProxyHost())) {
                webClient.getOptions().setProxyConfig(proxyConfig);
            }
        }
        return webClient;
    }

    protected void close(WebClient webClient) {
        if (webClient != null) {
            webClient.close();
            webClient = null;
        }
    }
    public static void main(String[] args) {
//        try{
//            HtmlunitTest ht = new HtmlunitTest();
//            HashMap<String, String > header = new HashMap<>();
//            List<NameValuePair> reqParam = new ArrayList<>();
//            header.clear();
//            System.out.println(UUID.randomUUID().toString());
//            String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
//            System.out.println(uuid);
//            header.put("Content-Type", "application/json");
//            header.put("Accept", "application/json, text/javascript, */*");
//            header.put("Referer", "http://fanyi.youdao.com/");
//            header.put("Origin", "http://fanyi.youdao.com/");
//            header.put("Host", "fanyi.youdao.com");
//            header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
//            WebClient webClient = ht.initWebClient(null);
//            String url = "http://fanyi.youdao.com/translate_o?smartresult=dict&smartresult=rule&sessionFrom=https://www.baidu.com/link";
//            String bodyStr = "i=hello&from=AUTO&to=AUTO&smartresult=dict&client=fanyideskweb&salt="+System.currentTimeMillis()+"&sign=f" +
//                    String.valueOf(uuid)+"&doctype=json&version=2.1&keyfrom=fanyi.web&action=FY_BY_ENTER&typoResult=true";
//            Cookie cookie = new Cookie("http://fanyi.youdao.com/","___rl__test__cookies",String.valueOf(System.currentTimeMillis()));
//            webClient.getCookieManager().addCookie(cookie);
//            cookie = new Cookie("http://fanyi.youdao.com/","_ntes_nnid","cba5f2c933102f765da5f9c9e37789de,1489564461107");
//            webClient.getCookieManager().addCookie(cookie);
//            cookie = new Cookie("http://fanyi.youdao.com/","OUTFOX_SEARCH_USER_ID_NCOO","146868758.6605451");
//            webClient.getCookieManager().addCookie(cookie);
//            cookie = new Cookie("http://fanyi.youdao.com/","OUTFOX_SEARCH_USER_ID","427352844@116.236.217.150");
//            webClient.getCookieManager().addCookie(cookie);
//            cookie = new Cookie("http://fanyi.youdao.com/","JSESSIONID","aaaLTgEVEV_H_5YFVfOZv");
//            webClient.getCookieManager().addCookie(cookie);
//            cookie = new Cookie("http://fanyi.youdao.com/","P_INFO","xinyanzhengxin@163.com|1490087556|0|other|00&99|shh&1490067197&mail163#shh&null#10#0#0|&0|mail163|xinyanzhengxin@163.com");
//            webClient.getCookieManager().addCookie(cookie);
//            cookie = new Cookie("http://fanyi.youdao.com/","SESSION_FROM_COOKIE","fanyiweb");
//            webClient.getCookieManager().addCookie(cookie);
//            cookie = new Cookie("http://fanyi.youdao.com/","YOUDAO_EAD_UUID","0b4fea8d-e190-4ac9-a6c4-c63a2591033c");
//            webClient.getCookieManager().addCookie(cookie);
////            System.out.println(bodyStr);
//
////            reqParam.add(new NameValuePair("i", "hello"));
////            reqParam.add(new NameValuePair("from", "AUTO"));
////            reqParam.add(new NameValuePair("to", "AUTO"));
////            reqParam.add(new NameValuePair("smartresult", "dict"));
//////            reqParam.add(new NameValuePair("smartresult", "rule"));
////            reqParam.add(new NameValuePair("client", "fanyideskweb"));
////            reqParam.add(new NameValuePair("salt", String.valueOf(System.currentTimeMillis())));
////            reqParam.add(new NameValuePair("sign", String.valueOf(UUID.randomUUID().toString().trim().replaceAll("-", ""))));
////            reqParam.add(new NameValuePair("doctype", "json"));
////            reqParam.add(new NameValuePair("version", "2.1"));
////            reqParam.add(new NameValuePair("keyfrom", "fanyi.web"));
////            reqParam.add(new NameValuePair("action", "FY_BY_ENTER"));
////            reqParam.add(new NameValuePair("typoResult", "true"));
//
//            Page page = ht.getPage(webClient, url, HttpMethod.POST, null,
//                    Constants.MAX_RETRY_TIIMES, null,header,bodyStr);
//            System.out.println(page.getWebResponse().getContentAsString());
//            HashMap<String, String> header = new HashMap<>();
//            List<NameValuePair> reqParam = new ArrayList<>();
//            try {
//                reqParam = new ArrayList<>();
//                reqParam.add(new NameValuePair("m", "15000281224"));
//                reqParam.add(new NameValuePair("p", "limu666"));
//                reqParam.add(new NameValuePair("to", ""));
//                reqParam.add(new NameValuePair("pa", "+86"));
//                Page resultPage = PageHelper.getPage(webClient, BASE_URL + "/login",
//                        HttpMethod.POST, reqParam, null);
//                String source = resultPage.getWebResponse().getContentAsString();
//                if (StringUtils.contains(source, "加载中")) {
//                    result.setSuccess();
//                } else if (StringUtils.contains(source, "用户名或密码错误") || StringUtils.contains(source, "账号或密码错误")) {//用户名或密码错误
//                    //登录错误,不需要重新尝试
//                    result.setStatus(StatusCode.USERNAME_OR_PASSWORD_ERROR);
//                } else {
//                    //登录错误,需要重新尝试
//                    result.setStatus(StatusCode.RESULT_CODE_4006);
//                }
//            } catch (Exception e) {
//                logger.error("==>[{}]0.登录出现异常", context.getTaskId(), e);
//                result.setStatus(StatusCode.LOGIN_FAIL_ERROR);
//                result.setMsg(e.getMessage());
//            } finally {
//                sendLoginMsg(result, context, webClient);
//                close(webClient);
//            }
//            logger.info("==>[{}]0.用户验证结束.", context.getTaskId());
//            return result;
//        }
//
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("有问题");
            String tmp = "pwq";
            String logFlag = String.format("==>6.["+tmp+"]套餐使用情况,第[{}]次尝试请求.....");
        System.out.println(logFlag);
//}
    }
}
