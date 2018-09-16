package com.pwq.DesignPatterns.SimpleFactory.RespPattern;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 14:12 2017/10/19
 * @Modified By：
 */
public class AHander extends Hander {
    public AHander(Hander hander) {
        super(hander);
    }

    @Override
    public String request(LeaveRequest leaveRequest) {
        if(0<leaveRequest.getDay()&&leaveRequest.getDay()>3){
            return "我是组长我来处理这种";
        }else{
            this.hander.request(leaveRequest);
        }
        return "处理失败";
    }
}
