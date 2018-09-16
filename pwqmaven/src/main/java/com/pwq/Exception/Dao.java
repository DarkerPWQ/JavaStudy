package com.pwq.Exception;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 16:42 2017/9/15
 * @Modified By：
 */
public class Dao {
    public void String(String s){
        if(null==s){
            throw new ServiceException("用户名为空");
        }
        if("pwq".equals(s)){
            throw new ServiceException("高级会员");
        }
        System.out.println("正常人");
    }
}
