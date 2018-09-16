package com.pwq.mavenT;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:58 2017/12/12
 * @Modified By：
 */
@Getter
@AllArgsConstructor
public enum  LoveEnum {
    青春("青春","回不去","大学"),
    爱情("爱情","逝去","社会");
    private String code;
    private String msg;
    private String type;

    public static String getCode(String msg){
        for(LoveEnum loveEnum:LoveEnum.values()){
            if(msg.equals(loveEnum.getMsg())){
                return loveEnum.getCode();
            }
        }
        return null;
    }
    public static String getMsg(String code){
        for(LoveEnum loveEnum:LoveEnum.values()){
            if(code.equals(loveEnum.getCode())){
                return loveEnum.getCode();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "LoveEnum{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
