package com.pwq.Enum;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 14:24 2017/9/11
 * @Modified By：
 */
public class EnumTest {
    public static void main(String[] args) {
        StatusCode statusCode = StatusCode.不支持初始密码登录;
        System.out.println(statusCode.getCode());
        System.out.println(statusCode.getMsg());
    }
}
