package com.pwq.utils;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.pwq.mavenT.CharsetCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 
 * @author YuYangjun
 * @date 2016年8月30日 下午2:44:05
 * @version V1.0
 */
public class PageHelper {
	
    private static Logger logger = LoggerFactory.getLogger(PageHelper.class);
	
	/**
	 * 获取页面
	 * @description 
	 * @author YuYangjun
	 * @create 2016年8月13日 上午9:48:59
     * @param webClient 访问客户端
     * @param url 访问地址
     * @param httpMethod 提交方法
     * @param params 访问参数
     * @param header 访问Header
	 * @return
	 */
    public static Page getPage(WebClient webClient,String url, HttpMethod httpMethod,List<NameValuePair> params, Map<String,String> header){
        return getPage(webClient,url,httpMethod,params, CharsetCode.UTF8,header);
    }
    
    /**
     * 获取页面
     * <b>有重复尝试机制</b>
     * @description 
     * @author YuYangjun
     * @create 2016年8月13日 上午9:48:59
     * @param webClient 访问客户端
     * @param url 访问地址
     * @param httpMethod 提交方法
     * @param params 访问参数
     * @param retryTimes 重复尝试次数
     * @param logFlag 日志标志
     * @return
     */
    public static Page getPage(WebClient webClient,String url, HttpMethod httpMethod,List<NameValuePair> params, 
    		int retryTimes, String logFlag, Map<String,String> header){
    	Page page;
    	int rt = 1;
    	while(rt <= retryTimes){
    		try{
    			logger.info(logFlag, rt);
    			page = getPage(webClient,url,httpMethod,params,CharsetCode.UTF8,header);
    			if(null != page){
    				return page;
    			}else{
    				logger.error("==>响应内容为空,正在两次尝试请求");
    				rt++;
    			}
    		}catch (Exception e) {
				logger.error("==>获取响应出错了,正在两次尝试请求:" , e);
				rt++;
			}
    	}
    	return null;
    }
    
    /**
     * 下载验证码图片并识别
     * @param surl
     * @return
     */
    public static String getVerifyCode(WebClient webClient,String surl, int codeType, HashMap<String,String> header){
        String verifyCode="";
        try{
	        URL url = new URL(surl);
	        WebRequest webRequest = new WebRequest(url, HttpMethod.GET);
	        if(null!= header){
				for(String key : header.keySet()){
					webRequest.setAdditionalHeader(key, header.get("key"));
				}
            }
            Page page =  webClient.getPage(webRequest);
//            verifyCode = CaptchaService.recognition(ImageIO.read(page.getWebResponse().getContentAsStream()),codeType);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return verifyCode;
    }
    
    //--------------------------------------------------------
    	//以下方法无须关注
    //--------------------------------------------------------
    
    private static Page getPage(WebClient webClient,String url, HttpMethod httpMethod, List<NameValuePair> params, 
    		CharsetCode charset, Map<String,String> header){
        if(httpMethod==HttpMethod.GET){
            return doGet(webClient,url,params,charset,header);
        }else {
            return doPost(webClient,url,params,charset,header);
        }
    }
    
    private static Page doPost(WebClient webClient,String pageUrl, List<NameValuePair> reqParam, 
    		CharsetCode charset, Map<String,String> header) {
        try{
            URL url = new URL(pageUrl);
            WebRequest webRequest = new WebRequest(url, HttpMethod.POST);
            webRequest.setAdditionalHeader("Accept-Language","zh-CN");
            if(charset==null){
                charset=CharsetCode.UTF8;
            }
            webRequest.setCharset(charset.getCode());
            if(reqParam!=null){
                webRequest.setRequestParameters(reqParam);
            }
            if(null!= header){
				for(String key : header.keySet()){
					webRequest.setAdditionalHeader(key, header.get("key"));
				}
            }
            return webClient.getPage(webRequest);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    private static Page doGet(WebClient webClient,String pageUrl, List<NameValuePair> reqParam, 
    		CharsetCode charset, Map<String, String> header) {
        try{
        	URL url;
            if(CollectionUtil.isEmpty(reqParam)){
            	 url = new URL(pageUrl);
            }else{
                url = new URL(pageUrl+"?"+EntityUtils.toString(reqParam));
            }

            WebRequest webRequest = new WebRequest(url, HttpMethod.GET);
            if(null!= header){
				for(String key : header.keySet()){
					webRequest.setAdditionalHeader(key, header.get("key"));
				}
            }
            return webClient.getPage(webRequest);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
