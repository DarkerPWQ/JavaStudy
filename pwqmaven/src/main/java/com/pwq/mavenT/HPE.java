package com.pwq.mavenT;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.pwq.utils.CollectionUtil;
import com.pwq.utils.EntityUtils;
import com.pwq.utils.RegexUtils;
import com.pwq.utils.StringUtils;
import org.junit.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.*;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 17:12 2017/7/31
 * @Modified By：
 */
public class HPE {
    private String name = "manage";
    private String password = "!manage";
    private String url = "https://192.168.161.201/v3/index.html";
    private String url38 = "https://192.168.161.38/v3/index.html";
    WebClient webClient;
    protected static Logger logger = LoggerFactory.getLogger(HPE.class);




    @Test
    public void login38() {
        webClient = initWebClient(webClient);
        //创建Client客户端
        logger.info("==>[{}]登陆开始......");
        Page page = getPage(webClient, url, HttpMethod.GET, null, null);
        System.out.println(webClient.getCookieManager());
        HashMap<String, String> header = new HashMap<>();
        header.put("Referer", "https://192.168.161.38/v3/index.html");
        header.put("datatype", "xml");
        List<NameValuePair> reqParam = new ArrayList<>();
        String bodyStr = "/api/login/539e12f63b693a9970a97b885e857f8b";
        String wurl = "https://192.168.161.38/v3/api/";
        Page resultPage = getPage(webClient, wurl, HttpMethod.POST, null, header, bodyStr);
        System.out.println(resultPage.getWebResponse().getContentAsString());
        String response = resultPage.getWebResponse().getContentAsString();
        System.out.println(System.currentTimeMillis());
        if (StringUtils.contains(response, "success")) {
            System.out.println("登录成功");
            String sessionKey = RegexUtils.matchValue("name=\"response\">(.*?)</PROPERTY>", response);
            System.out.println(sessionKey);
            while (true) {
                url = "https://192.168.161.38/v3/api/show/host-port-statistics?_=" + System.currentTimeMillis();
                Cookie cookie = new Cookie("https://192.168.161.38", "wbiusername", name);
                webClient.getCookieManager().addCookie(cookie);
                cookie = new Cookie("https://192.168.161.38", "wbisessionkey", sessionKey);
                webClient.getCookieManager().addCookie(cookie);
                Set<Cookie> cookieSet = webClient.getCookieManager().getCookies();
                for (Cookie c : cookieSet) {
                    System.out.println(c);
                }
                header.clear();
                header.put("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 10.0; WOW64; Trident/7.0; .NET4.0C; .NET4.0E; .NET CLR 2.0.50727; .NET CLR 3.0.30729; .NET CLR 3.5.30729)");
                header.put("Referer", "https://192.168.161.38/v3/index.html");
                header.put("Connection", "Keep-Alive");
                header.put("sessionkey", sessionKey);
                String urlHost = "https://192.168.161.38/v3/api/show/host-port-statistics?_=1501505153069";
                page = getPage(webClient, urlHost, HttpMethod.GET, null, header);
                String resource = page.getWebResponse().getContentAsString();
                System.out.println(resource);
                String iops = getIOPS(resource);
                String Byte = getBytes(resource);
                System.out.println(iops);
                System.out.println(Byte + "MB/s");
                try {
                    Thread.sleep(40 * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
    }


    @Test
    public void login() {
        webClient = initWebClient(webClient);
        //创建Client客户端
        logger.info("==>[{}]登陆开始......");
        Page page = getPage(webClient, url, HttpMethod.GET, null, null);
        System.out.println(webClient.getCookieManager());
        HashMap<String, String> header = new HashMap<>();
        header.put("Referer", "https://192.168.161.201/v3/index.html");
        header.put("datatype", "xml");
        List<NameValuePair> reqParam = new ArrayList<>();
        String bodyStr = "/api/login/539e12f63b693a9970a97b885e857f8b";
        String wurl = "https://192.168.161.201/v3/api/";
        Page resultPage = getPage(webClient, wurl, HttpMethod.POST, null, header, bodyStr);
        System.out.println(resultPage.getWebResponse().getContentAsString());
        String response = resultPage.getWebResponse().getContentAsString();
        System.out.println(System.currentTimeMillis());
        if (StringUtils.contains(response, "success")) {
            System.out.println("登录成功");
            String sessionKey = RegexUtils.matchValue("name=\"response\">(.*?)</PROPERTY>", response);
            System.out.println(sessionKey);
            while(true){
                url = "https://192.168.161.201/v3/api/show/host-port-statistics?_="+System.currentTimeMillis();
                Cookie cookie = new Cookie("https://192.168.161.201", "wbiusername", name);
                webClient.getCookieManager().addCookie(cookie);
                cookie = new Cookie("https://192.168.161.201", "wbisessionkey", sessionKey);
                webClient.getCookieManager().addCookie(cookie);
                Set<Cookie> cookieSet = webClient.getCookieManager().getCookies();
                for (Cookie c : cookieSet) {
                    System.out.println(c);
                }
                header.clear();
                header.put("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 10.0; WOW64; Trident/7.0; .NET4.0C; .NET4.0E; .NET CLR 2.0.50727; .NET CLR 3.0.30729; .NET CLR 3.5.30729)");
                header.put("Referer", "https://192.168.161.201/v3/index.html");
                header.put("Connection", "Keep-Alive");
                header.put("sessionkey", sessionKey);
                String urlHost = "https://192.168.161.201/v3/api/show/host-port-statistics?_=1501505153069";
                page = getPage(webClient, urlHost, HttpMethod.GET, null, header);
                String resource = page.getWebResponse().getContentAsString();
                System.out.println(resource);
                String iops  = getIOPS(resource);
                String Byte = getBytes(resource);
                System.out.println(iops);
                System.out.println(Byte+"MB/s");
                try{
                    Thread.sleep(40*1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }


        }
    }

    /**
     * @Author: WenqiangPu
     * @Description:
     * @param resource
     * @return:
     * @Date: 20:28 2017/7/31
     */
    public String getIOPS(String resource){
        String[] IOPSList = RegexUtils.matchMutiValue("display-name=\"IOPS\">(\\d+)</PROPERTY>",resource);
        int sumIOPS = 0;
        for(String i:IOPSList){
            sumIOPS+=Integer.parseInt(i);
        }
        System.out.println(sumIOPS);
        return String.valueOf(sumIOPS);
    }

    public String getBytes(String resource){
        String[] IOPSList = RegexUtils.matchMutiValue("<PROPERTY name=\"bytes-per-second-numeric\" .*?\">(\\d+)</PROPERTY>",resource);
        int sumBytes = 0;
        for(String i:IOPSList){
            sumBytes+=Integer.parseInt(i);
        }
        System.out.println(String.valueOf(Math.round(Double.parseDouble(String.valueOf(sumBytes/100000))/10)));
        return String.valueOf(Math.round(Double.parseDouble(String.valueOf(sumBytes/100000))/10));
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
        return webClient;
    }

    protected void close(WebClient webClient) {
        if (webClient != null) {
            webClient.close();
            webClient = null;
        }
    }
    public Page getPage(WebClient webClient, String url, HttpMethod httpMethod, List<NameValuePair> params, Map<String, String> header) {
        return getPage(webClient, url, httpMethod, params, CharsetCode.UTF8, header);
    }

    /**
     * 获取页面
     *
     * @param webClient  访问客户端
     * @param url        访问地址
     * @param httpMethod 提交方法
     * @param params     访问参数
     * @param header     访问Header
     * @param bodyStr    Body参数
     * @return
     * @description
     * @author heliang
     * @create 2016年8月13日 上午9:48:59
     */
    public Page getPage(WebClient webClient, String url, HttpMethod httpMethod, List<NameValuePair> params, Map<String, String> header, String bodyStr) {
        return getPage(webClient, url, httpMethod, params, CharsetCode.UTF8, header, bodyStr);
    }

    /**
     * 获取页面
     * <b>有重复尝试机制</b>
     *
     * @param webClient  访问客户端
     * @param url        访问地址
     * @param httpMethod 提交方法
     * @param params     访问参数
     * @param retryTimes 重复尝试次数
     * @param logFlag    日志标志
     * @param header     访问Header
     * @return
     * @description
     * @author heliang
     * @create 2016年8月13日 上午9:48:59
     */
    public Page getPage(WebClient webClient, String url, HttpMethod httpMethod, List<NameValuePair> params,
                        int retryTimes, String logFlag, Map<String, String> header) {
        Page page;
        int rt = 1;
        while (rt <= retryTimes) {
            try {
                page = getPage(webClient, url, httpMethod, params, CharsetCode.UTF8, header);
                if (null != page) {
                    return page;
                } else {
                    rt++;
                }
            } catch (Exception e) {
                rt++;
                try {
                    Thread.sleep(5000);
                } catch (Exception ex) {
                }
            }
        }
        return null;
    }

    /**
     * 获取页面
     * <b>有重复尝试机制</b>
     *
     * @param webClient   访问客户端
     * @param url         访问地址
     * @param httpMethod  提交方法
     * @param params      访问参数
     * @param retryTimes  重复尝试次数
     * @param logFlag     日志标志
     * @param header      访问Header
     * @param charsetCode 请求编码
     * @return
     * @description
     * @author york
     * @create 2016年9月23日 上午11:48:59
     */
    public Page getPage(WebClient webClient, String url, HttpMethod httpMethod, List<NameValuePair> params,
                        int retryTimes, String logFlag, Map<String, String> header, CharsetCode charsetCode) {
        Page page;
        int rt = 1;
        while (rt <= retryTimes) {
            try {
                page = getPage(webClient, url, httpMethod, params, charsetCode, header);
                if (null != page) {
                    return page;
                } else {
                    rt++;
                }
            } catch (Exception e) {
                rt++;
                try {
                    Thread.sleep(5000);
                } catch (Exception ex) {
                }
            }
        }
        return null;
    }

    /**
     * 获取页面
     * <b>有重复尝试机制</b>
     *
     * @param webClient  访问客户端
     * @param url        访问地址
     * @param httpMethod 提交方法
     * @param params     访问参数
     * @param retryTimes 重复尝试次数
     * @param logFlag    日志标志
     * @param header     访问Header
     * @param bodyStr    Body参数
     * @return
     * @description
     * @author heliang
     * @create 2016年8月13日 上午9:48:59
     */
    public Page getPage(WebClient webClient, String url, HttpMethod httpMethod, List<NameValuePair> params,
                        int retryTimes, String logFlag, Map<String, String> header, String bodyStr) {
        Page page;
        int rt = 1;
        while (rt <= retryTimes) {
            try {
                page = getPage(webClient, url, httpMethod, params, CharsetCode.UTF8, header, bodyStr);
                if (null != page) {
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

    /**
     * 获取页面
     *
     * @param webClient  访问客户端
     * @param url        访问地址
     * @param httpMethod 提交方法
     * @param params     访问参数
     * @param header     访问Header
     * @return
     * @description
     * @author heliang
     * @create 2016年8月13日 上午9:48:59
     */
    public Page getPage(WebClient webClient, String url, HttpMethod httpMethod, List<NameValuePair> params, Map<String, String> header, CharsetCode charsetCode) {
        return getPage(webClient, url, httpMethod, params, charsetCode, header);
    }

    //--------------------------------------------------------
    //以下方法无须关注
    //--------------------------------------------------------

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

}
