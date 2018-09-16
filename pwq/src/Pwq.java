
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;

import java.util.concurrent.locks.ReentrantLock;

public class Pwq {
    public static void main(String[] args) {
        System.out.println("contentEncoding:");
        ReentrantLock
//        //创建HttpClientBuilder
//        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
//        //HttpClient
//        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
//
//        HttpGet httpGet = new HttpGet("http://www.gxnu.edu.cn/default.html");
//        System.out.println(httpGet.getRequestLine());
//        try {
//            //执行get请求
//            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
//            //获取响应消息实体
//            HttpEntity entity = httpResponse.getEntity();
//            //响应状态
//            System.out.println("status:" + httpResponse.getStatusLine());
//            //判断响应实体是否为空
//            if (entity != null) {
//                System.out.println("contentEncoding:" + entity.getContentEncoding());
//                System.out.println("response content:" + EntityUtils.toString(entity));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                //关闭流并释放资源
//                closeableHttpClient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        String url = "http://www.google.com.hk";
//
//        final WebClient webClient = new WebClient();
//        HtmlPage htmlPage = webClient.getPage(url);
//        }
    }
}
