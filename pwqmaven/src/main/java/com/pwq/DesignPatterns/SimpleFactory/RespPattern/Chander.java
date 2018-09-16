package com.pwq.DesignPatterns.SimpleFactory.RespPattern;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 14:21 2017/10/19
 * @Modified By：
 */
public class Chander extends Hander {
    public Chander(Hander hander) {
        super(hander);
    }

    @Override
    public String request(LeaveRequest leaveRequest) {
        if(leaveRequest.getDay()<30){
            return "我是老板我来处理";
        }else {
            return "老板处理不行，审批失败";
        }
    }
}
