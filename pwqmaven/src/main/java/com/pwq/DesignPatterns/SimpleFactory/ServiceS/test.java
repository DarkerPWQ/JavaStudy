package com.pwq.DesignPatterns.SimpleFactory.ServiceS;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 9:57 2017/11/3
 * @Modified By：
 */
public class test {
    public static void main(String[] args) throws Exception {
        Service service = null;
        String proname = "A";
        if("A".equals(proname)){
            //提供A服务
            Provider provider = new Aprovider();
            service  = provider.proService();
        }
        else if("B".equals(proname)){
            //提供B服务
            Provider provider = new Bprovider();
            service  = provider.proService();
        }else{
            throw new Exception("没有这个服务");
        }
        service.service();

    }
}
