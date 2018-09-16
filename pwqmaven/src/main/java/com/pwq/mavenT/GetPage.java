package com.pwq.mavenT;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.pwq.utils.CollectionUtil;
import com.pwq.utils.EntityUtils;
import com.pwq.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 16:38 2017/7/27
 * @Modified By：
 */
public class GetPage {
    //是否允许代理
    protected static boolean enableProxy = false;
    //代理配置
    private static ProxyConfig proxyConfig = new ProxyConfig();
    protected static Logger logger = LoggerFactory.getLogger(GetPage.class);

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
                getLogger().info(logFlag, rt);
                page = getPage(webClient, url, httpMethod, params, CharsetCode.UTF8, header);
                if (null != page) {
                    return page;
                } else {
                    getLogger().error("==>响应内容为空,正在再次尝试请求");
                    rt++;
                }
            } catch (Exception e) {
                getLogger().error("==>获取响应出错了,正在再次尝试请求:", e);
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
                getLogger().info(logFlag, rt);
                page = getPage(webClient, url, httpMethod, params, charsetCode, header);
                if (null != page) {
                    return page;
                } else {
                    getLogger().error("==>响应内容为空,正在再次尝试请求");
                    rt++;
                }
            } catch (Exception e) {
                getLogger().error("==>获取响应出错了,正在再次尝试请求:", e);
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
                getLogger().info(logFlag, rt);
                page = getPage(webClient, url, httpMethod, params, CharsetCode.UTF8, header, bodyStr);
                if (null != page) {
                    return page;
                } else {
                    getLogger().error("==>响应内容为空,正在再次尝试请求");
                    rt++;
                }
            } catch (Exception e) {
                getLogger().error("==>获取响应出错了,正在再次尝试请求:", e);
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

    /**
     * 创建默认的webclient
     * <b>如果需要特殊处理,需要重写些方法</b>
     *
     * @return
     */
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
    protected Logger getLogger() {
        return logger;
    }

}
