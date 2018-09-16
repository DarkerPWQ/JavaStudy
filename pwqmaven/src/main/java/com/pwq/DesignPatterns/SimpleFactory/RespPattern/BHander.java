package com.pwq.DesignPatterns.SimpleFactory.RespPattern;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 14:19 2017/10/19
 * @Modified By：
 */
public class BHander extends Hander{
    public BHander(Hander hander) {
        super(hander);
    }

    @Override
    public String request(LeaveRequest leaveRequest) {
        if(leaveRequest.getDay()>3&&leaveRequest.getDay()<10){
            return "我是主管我来处理";
        }else {
            this.hander.request(leaveRequest);
        }
        return "处理失败";
    }
}
